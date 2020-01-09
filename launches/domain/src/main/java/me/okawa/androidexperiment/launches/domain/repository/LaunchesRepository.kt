package me.okawa.androidexperiment.launches.domain.repository

import me.okawa.androidexperiment.core.data.Result
import me.okawa.androidexperiment.launches.domain.model.LaunchModel

interface LaunchesRepository {

    suspend fun getLaunches(): Result<List<LaunchModel>>

    suspend fun getLaunch(flightNumber: Int): Result<LaunchModel>

}