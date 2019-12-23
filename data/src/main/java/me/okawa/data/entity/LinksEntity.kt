package me.okawa.data.entity

import com.google.gson.annotations.SerializedName
import me.okawa.domain.model.LinksModel

data class LinksEntity(
    @SerializedName("mission_patch")
    val missionPatch: String?,
    @SerializedName("mission_patch_small")
    val missionPatchSmall: String?,
    @SerializedName("article_link")
    val articleLink: String?,
    @SerializedName("youtube_id")
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