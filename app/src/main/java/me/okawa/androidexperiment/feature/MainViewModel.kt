package me.okawa.androidexperiment.feature

import androidx.compose.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.surface.Surface
import kotlinx.coroutines.Dispatchers
import me.okawa.androidexperiment.model.Launch
import me.okawa.androidexperiment.model.mapToPresentation
import me.okawa.domain.model.LaunchModel
import me.okawa.domain.repository.Result
import me.okawa.domain.usecase.LaunchesUseCase

class MainViewModel(private val launchesUseCase: LaunchesUseCase) : ViewModel() {

    val viewState: LiveData<ViewState> = liveData(Dispatchers.IO) {
        emit(retrieveLaunches())
    }

    private suspend fun retrieveLaunches(): ViewState {
        return when (val result = launchesUseCase.retrieveLaunches()) {
            is Result.Success -> onSuccess(result)
            is Result.NetworkError -> onNetworkError(result.message.orEmpty())
            is Result.GenericError -> onGenericError(result.message.orEmpty())
        }
    }

    private fun onSuccess(result: Result.Success<List<LaunchModel>>): ViewState {
        return ViewState.ShowLaunches(result.value.map { it.mapToPresentation() })
    }

    private fun onNetworkError(message: String): ViewState {
        return ViewState.NetworkError(message)
    }

    private fun onGenericError(message: String): ViewState {
        return ViewState.GenericError(message)
    }

    sealed class ViewState {
        abstract fun buildUI()

        data class ShowLaunches(val launches: List<Launch>): ViewState() {
            override fun buildUI() {
                newLaunchesList(launches)
            }
        }

        data class NetworkError(val message: String): ViewState() {
            override fun buildUI() {

            }
        }

        data class GenericError(val message: String): ViewState() {
            override fun buildUI() {

            }
        }

        @Composable
        fun newLaunchesList(launches: List<Launch>) {
            VerticalScroller {
                Column {
                    HeightSpacer(2.dp)
                    launches.forEach { launch ->
                        newLaunch(launch)
                    }
                }
            }
        }

        @Composable
        fun newLaunch(launch: Launch) {
            Column(modifier = Spacing(8.dp)) {
                Text(launch.missionName, maxLines = 1)
                Text(launch.details, maxLines = 3)
            }
        }
    }

}