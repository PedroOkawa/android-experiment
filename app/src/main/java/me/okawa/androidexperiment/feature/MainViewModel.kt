package me.okawa.androidexperiment.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import me.okawa.androidexperiment.model.Launch
import me.okawa.androidexperiment.model.mapToPresentation
import me.okawa.domain.model.LaunchModel
import me.okawa.domain.repository.Result
import me.okawa.domain.usecase.LaunchesUseCase

class MainViewModel(private val launchesUseCase: LaunchesUseCase) : ViewModel() {

    val launches: LiveData<State> = liveData(Dispatchers.IO) {
        emit(retrieveLaunches())
    }

    private suspend fun retrieveLaunches(): State {
        return when (val result = launchesUseCase.retrieveLaunches()) {
            is Result.Success -> onSuccess(result)
            is Result.NetworkError -> onError(result.message.orEmpty())
            is Result.GenericError -> onError(result.message.orEmpty())
        }
    }

    private fun onSuccess(result: Result.Success<List<LaunchModel>>): State {
        return State.ShowLaunches(result.value.map { it.mapToPresentation() })
    }

    private fun onError(message: String): State {
        return State.Error(message)
    }

    sealed class State {
        data class ShowLaunches(val launches: List<Launch>): State()
        data class Error(val message: String): State()
    }

}