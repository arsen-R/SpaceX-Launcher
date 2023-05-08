package com.example.spacex.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Rocket(
    val rocketId: String? = null,
    val rocketName: String? = null,
    val rocketType: String? = null
)
