package me.okawa.data.api

import me.okawa.data.entity.LaunchEntity
import retrofit2.http.GET

interface SpaceXApi {

    @GET("launches")
    suspend fun getLaunches(): List<LaunchEntity>

}