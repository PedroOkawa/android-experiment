package me.okawa.androidexperiment.launches.feature.home

import me.okawa.androidexperiment.composable.error.errorView
import me.okawa.androidexperiment.core.feature.ui.ViewState
import me.okawa.androidexperiment.launches.feature.composable.launchesListView
import me.okawa.androidexperiment.launches.feature.model.Launch

sealed class HomeViewState : ViewState

data class ShowLaunches(
    val launches: List<Launch>,
    val onLaunchClick: (Int) -> Unit
): HomeViewState() {
    override fun buildUI() {
        launchesListView(launches, onLaunchClick)
    }
}

data class ShowError(val message: String): HomeViewState() {
    override fun buildUI() {
        errorView(message)
    }
}