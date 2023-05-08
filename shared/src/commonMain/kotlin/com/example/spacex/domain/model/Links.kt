package com.example.spacex.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Links(
    val missionPatch: String? = null,
    val articleLink: String? = null
) {
}