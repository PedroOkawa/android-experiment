package me.okawa.data.entity

import me.okawa.domain.model.FlightModel
import java.util.*

data class FlightEntity(
    val flightNumber: Int?,
    val missionName: String?,
    val missionId: List<String>?,
    val upcoming: Boolean?,
    val launchYear: String?,
    val launchDate: Date?,
    val isTentative: Boolean?,
    val tentativeMaxPrecision: String?,
    val toBeDeployed: Boolean?,
    val rocket: RocketEntity?,
    val launchSuccess: Boolean?,
    val details: String?,
    val links: LinksEntity?
) {
    fun mapToDomain(): FlightModel {
        return FlightModel(
            flightNumber ?: 0,
            missionName.orEmpty(),
            missionId.orEmpty(),
            upcoming ?: false,
            launchYear.orEmpty(),
            launchDate,
            isTentative ?: false,
            tentativeMaxPrecision.orEmpty(),
            toBeDeployed ?: false,
            rocket?.mapToDomain(),
            launchSuccess ?: false,
            details.orEmpty(),
            links?.mapToDomain()
        )
    }
}