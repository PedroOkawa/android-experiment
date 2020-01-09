package me.okawa.androidexperiment.launches.feature.details

import android.util.Log
import me.okawa.androidexperiment.composable.error.errorView
import me.okawa.androidexperiment.core.feature.ui.ViewState
import me.okawa.androidexperiment.launches.feature.composable.launchesListView
import me.okawa.androidexperiment.launches.feature.model.Launch

sealed class DetailsViewState : ViewState

data class ShowDetails(val launch: Launch): DetailsViewState() {
    override fun buildUI() {
        Log.w("TEST", "LAUNCH: $launch")
        //launchesListView(launches)
    }
}

data class ShowError(val message: String): DetailsViewState() {
    override fun buildUI() {
        errorView(message)
    }
}