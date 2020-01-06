package me.okawa.androidexperiment.home.domain.repository

import me.okawa.androidexperiment.core.data.Result
import me.okawa.androidexperiment.home.domain.model.LaunchModel

interface LaunchesRepository {

    suspend fun getLaunches(): Result<List<LaunchModel>>

}