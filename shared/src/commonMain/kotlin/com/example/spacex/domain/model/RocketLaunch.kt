package com.example.spacex.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class RocketLaunch(
    val flightNumber: Int? = null,
    val missionName: String? = null,
    val launchYear: String? = null,
    val launchDateUtc: String? = null,
    val details: String? = null,
    val launchSuccess: Boolean? = null,
    val rocket: Rocket? = null,
    val links: Links? = null
)
