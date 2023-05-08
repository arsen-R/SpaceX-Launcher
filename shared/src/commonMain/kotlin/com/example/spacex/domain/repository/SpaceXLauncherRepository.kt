package com.example.spacex.domain.repository

import com.example.spacex.data.network.Result
import com.example.spacex.domain.model.RocketLaunch
import kotlinx.coroutines.flow.Flow

interface SpaceXLauncherRepository {

    suspend fun getLaunchers(): Flow<Result<List<RocketLaunch>>>
}