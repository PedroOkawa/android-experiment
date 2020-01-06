package me.okawa.home.feature.model

import me.okawa.home.domain.model.RocketModel

data class Rocket(
    val rocketId: String,
    val rocketName: String,
    val rocketType: String
)

fun RocketModel.mapToPresentation(): Rocket {
    return Rocket(
        rocketId,
        rocketName,
        rocketType
    )
}