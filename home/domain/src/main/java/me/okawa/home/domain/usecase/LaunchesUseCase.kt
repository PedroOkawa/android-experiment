package me.okawa.home.domain.usecase

import me.okawa.core.data.Result
import me.okawa.home.domain.model.LaunchModel
import me.okawa.home.domain.repository.LaunchesRepository

class LaunchesUseCase constructor(private val launchesRepository: LaunchesRepository) {
    suspend fun retrieveLaunches(): Result<List<LaunchModel>> {
        return launchesRepository.getLaunches()
    }
}