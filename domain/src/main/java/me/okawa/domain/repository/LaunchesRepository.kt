package me.okawa.domain.repository

import io.reactivex.Single
import me.okawa.domain.model.LaunchModel

interface LaunchesRepository {

    fun getFlights(): Single<List<LaunchModel>>

}