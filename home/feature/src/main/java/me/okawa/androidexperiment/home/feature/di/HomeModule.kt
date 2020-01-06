package me.okawa.androidexperiment.home.feature.di

import me.okawa.androidexperiment.home.data.api.SpaceXApi
import me.okawa.androidexperiment.home.data.repository.LaunchesRepositoryImpl
import me.okawa.androidexperiment.home.domain.repository.LaunchesRepository
import me.okawa.androidexperiment.home.domain.usecase.LaunchesUseCase
import me.okawa.androidexperiment.home.feature.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object HomeModule  {
    private val apiModule = module {
        single { retrieveSpaceXApi(get()) }
    }

    private val repositoriesModule = module {
        single<LaunchesRepository> { LaunchesRepositoryImpl(get()) }
    }

    private val useCasesModule = module {
        factory { LaunchesUseCase(get()) }
    }

    private val viewModelsModule = module {
        viewModel { HomeViewModel(get()) }
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
