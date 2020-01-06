package me.okawa.home.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import me.okawa.core.data.Result
import me.okawa.home.domain.model.LaunchModel
import me.okawa.home.domain.usecase.LaunchesUseCase
import me.okawa.home.feature.model.mapToPresentation

class HomeViewModel(private val launchesUseCase: LaunchesUseCase) : ViewModel() {
    val viewState: LiveData<HomeViewState> = liveData(Dispatchers.IO) {
        emit(retrieveLaunches())
    }

    private suspend fun retrieveLaunches(): HomeViewState {
        return when (val result = launchesUseCase.retrieveLaunches()) {
            is Result.Success -> onSuccess(result.value)
            is Result.Error -> onNetworkError(result.message.orEmpty())
        }
    }

    private fun onSuccess(launches: List<LaunchModel>): HomeViewState {
        return ShowLaunches(launches.map { it.mapToPresentation() })
    }

    private fun onNetworkError(message: String): HomeViewState {
        return ShowError(message)
    }
}