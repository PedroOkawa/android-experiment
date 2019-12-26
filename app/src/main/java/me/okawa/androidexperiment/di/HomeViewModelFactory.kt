package me.okawa.androidexperiment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.okawa.androidexperiment.feature.HomeViewModel
import org.kodein.di.Kodein
import org.kodein.di.direct
import org.kodein.di.generic.instance
import org.kodein.di.generic.instanceOrNull

class HomeViewModelFactory(private val kodein: Kodein): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return kodein.direct.instanceOrNull<ViewModel>(tag = modelClass.simpleName) as T? ?: when (modelClass) {
            HomeViewModel::class.java -> HomeViewModel(kodein.direct.instance()) as T
            else -> throw ClassCastException()
        }
    }
}