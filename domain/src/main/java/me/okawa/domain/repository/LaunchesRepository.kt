package me.okawa.domain.repository

import me.okawa.domain.model.LaunchModel

interface LaunchesRepository {

    suspend fun getFlights(): Result<List<LaunchModel>>

}