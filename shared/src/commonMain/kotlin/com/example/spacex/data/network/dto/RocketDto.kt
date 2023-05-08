package com.example.spacex.data.network.dto

import com.example.spacex.domain.model.Rocket
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketDto(
    @SerialName("rocket_id")
    val rocketId: String,
    @SerialName("rocket_name")
    val rocketName: String,
    @SerialName("rocket_type")
    val rocketType: String
) {
    fun toRocket(): Rocket {
        return Rocket(
            rocketId = this.rocketId,
            rocketName = this.rocketName,
            rocketType = this.rocketType
        )
    }
}