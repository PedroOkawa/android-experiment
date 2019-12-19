package me.okawa.data.cache

import io.reactivex.Single
import me.okawa.data.entity.FlightEntity

interface SpaceXDataCache {

    fun getFlights(): Single<List<FlightEntity>>

}