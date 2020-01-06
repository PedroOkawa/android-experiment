package me.okawa.androidexperiment.home.domain.model

import java.util.*

data class LaunchModel(
    val flightNumber: Int,
    val missionName: String,
    val missionId: List<String>,
    val upcoming: Boolean,
    val launchYear: String,
    val launchDate: Date?,
    val isTentative: Boolean,
    val tentativeMaxPrecision: String,
    val toBeDeployed: Boolean,
    val rocket: RocketModel?,
    val launchSuccess: Boolean,
    val details: String,
    val links: LinksModel?
)