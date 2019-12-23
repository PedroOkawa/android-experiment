package me.okawa.data.repository

import io.reactivex.Single
import me.okawa.data.api.SpaceXApi
import me.okawa.domain.model.LaunchModel
import me.okawa.domain.repository.LaunchesRepository

class LaunchesRepositoryImpl constructor(
    private val spaceXApi: SpaceXApi
) : LaunchesRepository {

    override fun getFlights(): Single<List<LaunchModel>> {
        return spaceXApi.getFlights()
            .map { flights ->
                flights.map { flight ->
                    flight.mapToDomain()
                }
            }
    }
}