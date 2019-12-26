package me.okawa.data.repository

import kotlinx.coroutines.Dispatchers
import me.okawa.domain.repository.Result
import me.okawa.data.api.SpaceXApi
import me.okawa.domain.model.LaunchModel
import me.okawa.domain.repository.LaunchesRepository

class LaunchesRepositoryImpl constructor(
    private val spaceXApi: SpaceXApi
) : BaseRepository(), LaunchesRepository {

    override suspend fun getFlights(): Result<List<LaunchModel>> {
        return callApi(Dispatchers.IO) { spaceXApi.getFlights().map { it.mapToDomain() } }
    }
}