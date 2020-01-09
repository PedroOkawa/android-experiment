package me.okawa.androidexperiment.di

import me.okawa.androidexperiment.ui.LauncherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LauncherModule {

    private val viewModelsModule = module {
        viewModel { LauncherViewModel() }
    }

    val modules = listOf(
        viewModelsModule
    )

}