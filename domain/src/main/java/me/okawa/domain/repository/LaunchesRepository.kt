package me.okawa.domain.repository

import me.okawa.domain.model.LaunchModel

interface LaunchesRepository {

    suspend fun getLaunches(): Result<List<LaunchModel>>

}