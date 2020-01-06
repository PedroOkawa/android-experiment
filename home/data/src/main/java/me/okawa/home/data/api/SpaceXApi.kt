package me.okawa.home.data.api

import me.okawa.home.data.entity.LaunchEntity
import retrofit2.http.GET

interface SpaceXApi {

    @GET("launches")
    suspend fun getLaunches(): List<LaunchEntity>

}