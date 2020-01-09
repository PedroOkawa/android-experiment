package me.okawa.androidexperiment.launches.feature.home

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import me.okawa.androidexperiment.core.data.Result
import me.okawa.androidexperiment.core.feature.SingleLiveEvent
import me.okawa.androidexperiment.launches.domain.model.LaunchModel
import me.okawa.androidexperiment.launches.domain.usecase.LaunchesUseCase
import me.okawa.androidexperiment.launches.feature.model.mapToPresentation

class HomeViewModel(private val launchesUseCase: LaunchesUseCase) : ViewModel() {

    private val _navigation = SingleLiveEvent<Navigation>()
    val navigation: LiveData<Navigation> = _navigation

    val viewState: LiveData<HomeViewState> = liveData(Dispatchers.IO) {
        emit(retrieveLaunches())
    }

    fun onBackPressed() {
        _navigation.postValue(Navigation.Finish)
    }

    private suspend fun retrieveLaunches(): HomeViewState {
        return when (val result = launchesUseCase.retrieveLaunches()) {
            is Result.Success -> onSuccess(result.value)
            is Result.Error -> onNetworkError(result.message.orEmpty())
        }
    }

    private fun onSuccess(launches: List<LaunchModel>): HomeViewState {
        return ShowLaunches(launches.map { it.mapToPresentation() }, ::onLaunchClicked)
    }

    private fun onNetworkError(message: String): HomeViewState {
        return ShowError(message)
    }

    private fun onLaunchClicked(flightNumber: Int) {
        _navigation.postValue(Navigation.Details(flightNumber))
    }

    sealed class Navigation {
        data class Details(val flightNumber: Int) : Navigation()
        object Finish : Navigation()
    }
}