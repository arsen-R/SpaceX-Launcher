package com.example.spacex.data.repository

import com.example.spacex.data.SpaceXService
import com.example.spacex.data.mapper.RocketMapper
import com.example.spacex.data.network.Result
import com.example.spacex.domain.model.RocketLaunch
import com.example.spacex.domain.repository.SpaceXLauncherRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class SpaceXLauncherRepositoryImpl : SpaceXLauncherRepository {
    private val api: SpaceXService = SpaceXService.create()
    private val mapper: RocketMapper = RocketMapper()

    override suspend fun getLaunchers(): Flow<Result<List<RocketLaunch>>> {
        return flow {
            emit(Result.Loading)
            delay(5000L)
            val result = api.getLaunches()
            emit(Result.Success(result.map { mapper.toRocketLaunch(it) }))
        }.catch { exception ->
            emit(Result.Error(exception))
        }
    }


}