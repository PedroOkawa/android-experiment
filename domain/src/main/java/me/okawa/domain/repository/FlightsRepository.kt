package me.okawa.domain.repository

import io.reactivex.Single
import me.okawa.domain.model.FlightModel

interface FlightsRepository {

    fun getFlights(): Single<List<FlightModel>>

}