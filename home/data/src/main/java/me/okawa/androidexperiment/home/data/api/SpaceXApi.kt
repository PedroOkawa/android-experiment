package me.okawa.androidexperiment.home.data.api

import me.okawa.androidexperiment.home.data.entity.LaunchEntity
import retrofit2.http.GET

interface SpaceXApi {

    @GET("launches")
    suspend fun getLaunches(): List<LaunchEntity>

}