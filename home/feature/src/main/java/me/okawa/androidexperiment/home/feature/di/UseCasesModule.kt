package me.okawa.androidexperiment.home.feature.di

import me.okawa.androidexperiment.home.domain.repository.LaunchesRepository
import me.okawa.androidexperiment.home.domain.usecase.LaunchesUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

private const val MODULE_NAME = "Home Use Cases Module"

val homeUseCasesModule = Kodein.Module(MODULE_NAME) {
    bind<LaunchesUseCase>() with singleton {
        retrieveLaunchesUseCase(
            instance()
        )
    }
}

private fun retrieveLaunchesUseCase(launchesRepository: LaunchesRepository): LaunchesUseCase {
    return LaunchesUseCase(launchesRepository)
}