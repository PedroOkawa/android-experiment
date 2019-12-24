package me.okawa.androidexperiment.model

import me.okawa.domain.model.RocketModel

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