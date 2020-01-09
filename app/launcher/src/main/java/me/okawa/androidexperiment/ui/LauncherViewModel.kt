package me.okawa.androidexperiment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.okawa.androidexperiment.core.feature.SingleLiveEvent

class LauncherViewModel : ViewModel() {

    private val _navigation = SingleLiveEvent<Navigation>()
    val navigation: LiveData<Navigation> = _navigation

    fun openHome() {
        _navigation.postValue(Navigation.Home)
    }

    sealed class Navigation {
        object Home : Navigation()
    }

}