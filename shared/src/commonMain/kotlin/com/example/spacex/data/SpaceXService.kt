package com.example.spacex.data

import com.example.spacex.data.network.api.SpaceXServiceImpl
import com.example.spacex.data.network.dto.RocketLaunchDto
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.kotlinx.serializer.KotlinxSerializer
import io.ktor.serialization.kotlinx.json.json


interface SpaceXService {
    suspend fun getLaunches(): List<RocketLaunchDto>

    companion object {
        fun create() : SpaceXService {
            return SpaceXServiceImpl(
                client = HttpClient {
                    install(ContentNegotiation) {
                        json(json = json)
                    }
                }
            )
        }
        private val json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = true
        }
    }
}