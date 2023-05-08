package com.example.spacex.data.mapper

import com.example.spacex.data.network.dto.RocketLaunchDto
import com.example.spacex.domain.model.RocketLaunch

class RocketMapper {
    fun toRocketLaunch(rocketLaunchDto: RocketLaunchDto): RocketLaunch {
        return RocketLaunch(
            flightNumber = rocketLaunchDto.flightNumber,
            missionName = rocketLaunchDto.missionName,
            launchYear = rocketLaunchDto.launchYear,
            launchDateUtc = rocketLaunchDto.launchDateUtc,
            details = rocketLaunchDto.details,
            launchSuccess = rocketLaunchDto.launchSuccess,
            rocket = rocketLaunchDto.rocket.toRocket(),
            links = rocketLaunchDto.links.toLinks()
        )
    }
    fun toListRocketLaunch(dtoCollection: Collection<RocketLaunchDto>) : List<RocketLaunch> =
        dtoCollection.map { toRocketLaunch(it) }
}