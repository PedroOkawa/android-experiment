package me.okawa.androidexperiment.launches.domain.usecase

import me.okawa.androidexperiment.core.data.Result
import me.okawa.androidexperiment.launches.domain.model.LaunchModel
import me.okawa.androidexperiment.launches.domain.repository.LaunchesRepository

class LaunchUseCase constructor(private val launchesRepository: LaunchesRepository) {
    suspend fun retrieveLaunch(args: Args): Result<LaunchModel> {
        return launchesRepository.getLaunch(args.flightNumber)
    }

    data class Args(val flightNumber: Int)
}