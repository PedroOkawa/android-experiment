package me.okawa.home.data.repository

import kotlinx.coroutines.Dispatchers
import me.okawa.core.data.BaseRepository
import me.okawa.core.data.Result
import me.okawa.home.domain.model.LaunchModel
import me.okawa.home.domain.repository.LaunchesRepository
import me.okawa.home.data.api.SpaceXApi

class LaunchesRepositoryImpl constructor(
    private val spaceXApi: SpaceXApi
) : BaseRepository(), LaunchesRepository {

    override suspend fun getLaunches(): Result<List<LaunchModel>> {
        return callApi(Dispatchers.IO) {
            spaceXApi.getLaunches().map { launchEntity ->
                launchEntity.mapToDomain()
            }
        }
    }
}