package me.okawa.data.api

import io.reactivex.Single
import me.okawa.data.entity.LaunchEntity
import retrofit2.http.GET

interface SpaceXApi {

    @GET("launches")
    fun getFlights(): Single<List<LaunchEntity>>

}