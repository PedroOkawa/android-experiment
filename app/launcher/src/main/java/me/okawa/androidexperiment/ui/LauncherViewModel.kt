package me.okawa.androidexperiment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class LauncherViewModel : ViewModel() {

    private val _navigation = MutableLiveData<Navigation>()
    val navigation: LiveData<Navigation> = Transformations.distinctUntilChanged(_navigation)

    fun openHome() {
        _navigation.postValue(Navigation.Home)
    }

    sealed class Navigation {
        object Home : Navigation()
    }

}