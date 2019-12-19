package me.okawa.data.entity

import me.okawa.domain.model.RocketModel

data class RocketEntity(
    val rocketId: String?,
    val rocketName: String?,
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