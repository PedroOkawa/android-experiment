package me.okawa.androidexperiment.launches.data.entity

import com.google.gson.annotations.SerializedName
import me.okawa.androidexperiment.launches.domain.model.RocketModel

data class RocketEntity(
    @SerializedName("rocket_id")
    val rocketId: String?,
    @SerializedName("rocket_name")
    val rocketName: String?,
    @SerializedName("rocket_type")
    val rocketType: String?
) {
    fun mapToDomain(): RocketModel {
        return RocketModel(
            rocketId.orEmpty(),
            rocketName.orEmpty(),
            rocketType.orEmpty()
        )
    }
}