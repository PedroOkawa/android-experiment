package me.okawa.androidexperiment.home.feature

import me.okawa.androidexperiment.composable.error.errorView
import me.okawa.androidexperiment.core.feature.ui.ViewState
import me.okawa.androidexperiment.home.feature.composable.launchesListView
import me.okawa.androidexperiment.home.feature.model.Launch

sealed class HomeViewState :
    ViewState

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