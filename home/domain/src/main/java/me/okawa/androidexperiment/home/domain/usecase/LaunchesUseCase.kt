package me.okawa.androidexperiment.home.domain.usecase

import me.okawa.androidexperiment.core.data.Result
import me.okawa.androidexperiment.home.domain.model.LaunchModel
import me.okawa.androidexperiment.home.domain.repository.LaunchesRepository

class LaunchesUseCase constructor(private val launchesRepository: LaunchesRepository) {
    suspend fun retrieveLaunches(): Result<List<LaunchModel>> {
        return launchesRepository.getLaunches()
    }
}