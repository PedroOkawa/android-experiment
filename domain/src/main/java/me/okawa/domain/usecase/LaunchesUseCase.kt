package me.okawa.domain.usecase

import io.reactivex.Single
import me.okawa.domain.model.LaunchModel
import me.okawa.domain.repository.LaunchesRepository

class LaunchesUseCase constructor(private val launchesRepository: LaunchesRepository) {

    fun retrieveLaunches(): Single<List<LaunchModel>> {
        return launchesRepository.getFlights()
    }

}