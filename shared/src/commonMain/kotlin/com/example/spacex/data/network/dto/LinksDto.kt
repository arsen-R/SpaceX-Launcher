package com.example.spacex.data.network.dto

import com.example.spacex.domain.model.Links
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class LinksDto(
    @SerialName("mission_patch")
    val missionPatch: String?,
    @SerialName("article_link")
    val articleLink: String?
) {
    fun toLinks(): Links {
        return Links(
            missionPatch = this.missionPatch,
            articleLink = this.articleLink
        )
    }
}