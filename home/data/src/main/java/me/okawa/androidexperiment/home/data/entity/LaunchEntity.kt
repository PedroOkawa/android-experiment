package me.okawa.androidexperiment.home.data.entity

import com.google.gson.annotations.SerializedName
import me.okawa.androidexperiment.home.domain.model.LaunchModel
import java.util.*

data class LaunchEntity(
    @SerializedName("flight_number")
    val flightNumber: Int?,
    @SerializedName("mission_name")
    val missionName: String?,
    @SerializedName("mission_id")
    val missionId: List<String>?,
    @SerializedName("upcoming")
    val upcoming: Boolean?,
    @SerializedName("launch_year")
    val launchYear: String?,
    @SerializedName("launch_date")
    val launchDate: Date?,
    @SerializedName("is_tentative")
    val isTentative: Boolean?,
    @SerializedName("tentative_max_precision")
    val tentativeMaxPrecision: String?,
    @SerializedName("to_be_deployed")
    val toBeDeployed: Boolean?,
    @SerializedName("rocket")
    val rocket: RocketEntity?,
    @SerializedName("launch_success")
    val launchSuccess: Boolean?,
    @SerializedName("details")
    val details: String?,
    @SerializedName("links")
    val links: LinksEntity?
) {
    fun mapToDomain(): LaunchModel {
        return LaunchModel(
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