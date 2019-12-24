package me.okawa.androidexperiment.di

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

private const val MODULE_NAME = "View Models Module"

val viewModelsModule = Kodein.Module(MODULE_NAME) {
    bind<MainViewModelFactory>() with singleton { retrieveMainViewModelFactory(instance()) }
}

private fun retrieveMainViewModelFactory(kodein: Kodein): MainViewModelFactory {
    return MainViewModelFactory(kodein)
}