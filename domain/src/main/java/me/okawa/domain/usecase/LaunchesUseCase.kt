package me.okawa.domain.usecase

import me.okawa.domain.model.LaunchModel
import me.okawa.domain.repository.LaunchesRepository
import me.okawa.domain.repository.Result

class LaunchesUseCase constructor(private val launchesRepository: LaunchesRepository) {
    suspend fun retrieveLaunches(): Result<List<LaunchModel>> {
        return launchesRepository.getLaunches()
    }
}