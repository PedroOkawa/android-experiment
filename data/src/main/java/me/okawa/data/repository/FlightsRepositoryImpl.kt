package me.okawa.data.repository

import io.reactivex.Single
import me.okawa.data.cache.SpaceXDataCache
import me.okawa.domain.model.FlightModel
import me.okawa.domain.repository.FlightsRepository

class FlightsRepositoryImpl constructor(
    private val spaceXDataCache: SpaceXDataCache
) : FlightsRepository {

    override fun getFlights(): Single<List<FlightModel>> {
        return spaceXDataCache.getFlights()
            .map { flights ->
                flights.map { flight ->
                    flight.mapToDomain()
                }
            }
    }
}