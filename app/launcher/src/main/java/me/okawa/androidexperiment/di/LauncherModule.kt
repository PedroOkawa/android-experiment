package me.okawa.androidexperiment.di

import me.okawa.androidexperiment.ui.LauncherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LauncherModule {

    private val viewModelsModule = module(override = true) {
        viewModel { LauncherViewModel() }
    }

    val modules = listOf(
        viewModelsModule
    )

}