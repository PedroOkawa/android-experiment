package me.okawa.androidexperiment.launches.data.api

import me.okawa.androidexperiment.launches.data.entity.LaunchEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXApi {

    @GET("launches")
    suspend fun getLaunches(): List<LaunchEntity>

    @GET("launches/{flightNumber}")
    suspend fun getLaunch(@Path("flightNumber") flightNumber: Int): LaunchEntity

}