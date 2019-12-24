package me.okawa.core.di

import me.okawa.domain.repository.LaunchesRepository
import me.okawa.domain.usecase.LaunchesUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

private const val MODULE_NAME = "Use Cases Module"

val useCasesModule = Kodein.Module(MODULE_NAME) {
    bind<LaunchesUseCase>() with singleton {
        retrieveLaunchesUseCase(
            instance()
        )
    }
}

private fun retrieveLaunchesUseCase(launchesRepository: LaunchesRepository): LaunchesUseCase {
    return LaunchesUseCase(launchesRepository)
}