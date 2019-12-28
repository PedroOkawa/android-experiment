package me.okawa.androidexperiment.feature

import me.okawa.androidexperiment.composable.error.errorView
import me.okawa.androidexperiment.composable.launch.launchesListView
import me.okawa.androidexperiment.model.Launch
import me.okawa.core.ui.ViewState

sealed class HomeViewState : ViewState

data class ShowLaunches(val launches: List<Launch>): HomeViewState() {
    override fun buildUI() {
        launchesListView(launches)
    }
}

data class ShowError(val message: String): HomeViewState() {
    override fun buildUI() {
        errorView(message)
    }
}