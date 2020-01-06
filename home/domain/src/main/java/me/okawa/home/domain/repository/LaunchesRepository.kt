package me.okawa.home.domain.repository

import me.okawa.core.data.Result
import me.okawa.home.domain.model.LaunchModel

interface LaunchesRepository {

    suspend fun getLaunches(): Result<List<LaunchModel>>

}