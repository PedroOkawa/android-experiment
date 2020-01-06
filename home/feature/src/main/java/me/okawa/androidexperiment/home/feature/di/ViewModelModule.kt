package me.okawa.androidexperiment.home.feature.di

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

private const val MODULE_NAME = "View Models Module"

val viewModelsModule = Kodein.Module(MODULE_NAME) {
    bind<HomeViewModelFactory>() with singleton {
        retrieveMainViewModelFactory(kodein)
    }
}

private fun retrieveMainViewModelFactory(kodein: Kodein): HomeViewModelFactory {
    return HomeViewModelFactory(kodein)
}