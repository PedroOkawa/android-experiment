package me.okawa.androidexperiment.launches.feature.di

import me.okawa.androidexperiment.launches.data.api.SpaceXApi
import me.okawa.androidexperiment.launches.data.repository.LaunchesRepositoryImpl
import me.okawa.androidexperiment.launches.domain.repository.LaunchesRepository
import me.okawa.androidexperiment.launches.domain.usecase.LaunchUseCase
import me.okawa.androidexperiment.launches.domain.usecase.LaunchesUseCase
import me.okawa.androidexperiment.launches.feature.details.DetailsViewModel
import me.okawa.androidexperiment.launches.feature.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object LaunchesModule {
    const val PROPERTY_FLIGHT_NUMBER = "flight_number"

    private val apiModule = module(override = true) {
        single { retrieveSpaceXApi(get()) }
    }

    private val repositoriesModule = module(override = true) {
        single<LaunchesRepository> { LaunchesRepositoryImpl(get()) }
    }

    private val useCasesModule = module(override = true) {
        factory { LaunchesUseCase(get()) }
        factory { LaunchUseCase(get()) }
    }

    private val viewModelsModule = module(override = true) {
        viewModel { HomeViewModel(get()) }
        viewModel { DetailsViewModel(get(), getProperty(PROPERTY_FLIGHT_NUMBER)) }
    }

    private fun retrieveSpaceXApi(retrofit: Retrofit): SpaceXApi {
        return retrofit.create(SpaceXApi::class.java)
    }

    val modules = listOf(
        apiModule,
        repositoriesModule,
        useCasesModule,
        viewModelsModule
    )
}