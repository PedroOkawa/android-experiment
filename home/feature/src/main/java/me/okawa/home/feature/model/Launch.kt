package me.okawa.home.feature.model

import me.okawa.home.domain.model.LaunchModel
import java.util.*

private const val NOT_AVAILABLE = "N/A"

data class Launch(
    val flightNumber: Int,
    val missionName: String,
    val missionId: List<String>,
    val upcoming: Boolean,
    val launchYear: String,
    val launchDate: Date?,
    val isTentative: Boolean,
    val tentativeMaxPrecision: String,
    val toBeDeployed: Boolean,
    val rocket: Rocket?,
    val launchSuccess: Boolean,
    val details: String,
    val links: Links?
)

fun LaunchModel.mapToPresentation(): Launch {
    return Launch(
        flightNumber,
        missionName.ifEmpty { NOT_AVAILABLE },
        missionId,
        upcoming,
        launchYear,
        launchDate,
        isTentative,
        tentativeMaxPrecision,
        toBeDeployed,
        rocket?.mapToPresentation(),
        launchSuccess,
        details.ifEmpty { NOT_AVAILABLE },
        links?.mapToPresentation()
    )
}