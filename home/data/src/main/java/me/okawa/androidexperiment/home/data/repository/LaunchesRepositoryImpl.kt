package me.okawa.androidexperiment.home.data.repository

import kotlinx.coroutines.Dispatchers
import me.okawa.androidexperiment.core.data.BaseRepository
import me.okawa.androidexperiment.core.data.Result
import me.okawa.androidexperiment.home.domain.model.LaunchModel
import me.okawa.androidexperiment.home.domain.repository.LaunchesRepository
import me.okawa.androidexperiment.home.data.api.SpaceXApi

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