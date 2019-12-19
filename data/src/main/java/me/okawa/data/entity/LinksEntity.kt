package me.okawa.data.entity

import me.okawa.domain.model.LinksModel

data class LinksEntity(
    val missionPatch: String?,
    val missionPatchSmall: String?,
    val articleLink: String?,
    val youtubeId: String?
) {
    fun mapToDomain() : LinksModel {
        return LinksModel(
            missionPatch.orEmpty(),
            missionPatchSmall.orEmpty(),
            articleLink.orEmpty(),
            youtubeId.orEmpty()
        )
    }
}