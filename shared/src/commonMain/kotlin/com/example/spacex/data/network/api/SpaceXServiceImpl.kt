package com.example.spacex.data.network.api

import com.example.spacex.data.ApiRoute
import com.example.spacex.data.SpaceXService
import com.example.spacex.data.network.dto.RocketLaunchDto
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException

import io.ktor.client.request.*

class SpaceXServiceImpl(
    val client: HttpClient
) : SpaceXService {
    override suspend fun getLaunches(): List<RocketLaunchDto> {
        return try {
            client.get { url(ApiRoute.LAUNCHES) }.body()
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            Napier.d(message = "EX 1")
            println("Error: ${ex.response.status.description}")
            emptyList()
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            Napier.d(message = "EX 2")
            println("Error: ${ex.response.status.description}")
            emptyList()
        } catch (ex: ServerResponseException) {
            // 5xx - response
            Napier.d(message = "EX 3")
            println("Error: ${ex.response.status.description}")
            emptyList()
        }
    }
}