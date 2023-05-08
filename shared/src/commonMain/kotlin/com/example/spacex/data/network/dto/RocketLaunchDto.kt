package com.example.spacex.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketLaunchDto(
    @SerialName("flight_number")
    val flightNumber: Int,
    @SerialName("mission_name")
    val missionName: String,
    @SerialName("launch_year")
    val launchYear: String,
    @SerialName("launch_date_utc")
    val launchDateUtc: String,
    @SerialName("details")
    val details: String?,
    @SerialName("launch_success")
    val launchSuccess: Boolean?,
    @SerialName("rocket")
    val rocket: RocketDto,
    @SerialName("links")
    val links: LinksDto
)