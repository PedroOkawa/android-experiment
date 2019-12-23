package me.okawa.core

import me.okawa.data.api.SpaceXApi
import me.okawa.data.repository.LaunchesRepositoryImpl
import me.okawa.domain.repository.LaunchesRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

private const val MODULE_NAME = "Repositories Module"

val repositoriesModule = Kodein.Module(MODULE_NAME) {
    bind<LaunchesRepository>() with singleton { retrieveLaunchesRepository(instance()) }
}

private fun retrieveLaunchesRepository(spaceXApi: SpaceXApi): LaunchesRepository {
    return LaunchesRepositoryImpl(spaceXApi)
}