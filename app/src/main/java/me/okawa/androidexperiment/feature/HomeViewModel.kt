package me.okawa.androidexperiment.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import me.okawa.androidexperiment.model.mapToPresentation
import me.okawa.domain.model.LaunchModel
import me.okawa.domain.repository.Result
import me.okawa.domain.usecase.LaunchesUseCase

class HomeViewModel(private val launchesUseCase: LaunchesUseCase) : ViewModel() {

    val viewState: LiveData<HomeViewState> = liveData(Dispatchers.IO) {
        emit(retrieveLaunches())
    }

    private suspend fun retrieveLaunches(): HomeViewState {
        return when (val result = launchesUseCase.retrieveLaunches()) {
            is Result.Success -> onSuccess(result)
            is Result.NetworkError -> onNetworkError(result.message.orEmpty())
            is Result.GenericError -> onGenericError(result.message.orEmpty())
        }
    }

    private fun onSuccess(result: Result.Success<List<LaunchModel>>): HomeViewState {
        return ShowLaunches(result.value.map { it.mapToPresentation() })
    }

    private fun onNetworkError(message: String): HomeViewState {
        return NetworkError(message)
    }

    private fun onGenericError(message: String): HomeViewState {
        return GenericError(message)
    }

}