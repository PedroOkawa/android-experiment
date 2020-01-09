package me.okawa.androidexperiment.launches.feature.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import me.okawa.androidexperiment.core.data.Result
import me.okawa.androidexperiment.launches.domain.model.LaunchModel
import me.okawa.androidexperiment.launches.domain.usecase.LaunchUseCase
import me.okawa.androidexperiment.launches.feature.model.mapToPresentation

class DetailsViewModel(
    private val launchUseCase: LaunchUseCase,
    private val flightNumber: Int
) : ViewModel() {
    val viewState: LiveData<DetailsViewState> = liveData(Dispatchers.IO) {
        emit(retrieveLaunches())
    }

    private suspend fun retrieveLaunches(): DetailsViewState {
        val args = LaunchUseCase.Args(flightNumber)
        return when (val result = launchUseCase.retrieveLaunch(args)) {
            is Result.Success -> onSuccess(result.value)
            is Result.Error -> onNetworkError(result.message.orEmpty())
        }
    }

    private fun onSuccess(launch: LaunchModel): DetailsViewState {
        return ShowDetails(launch.mapToPresentation())
    }

    private fun onNetworkError(message: String): DetailsViewState {
        return ShowError(message)
    }
}