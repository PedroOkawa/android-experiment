package me.okawa.androidexperiment.home.feature.model

import me.okawa.androidexperiment.home.domain.model.LinksModel

data class Links(
    val missionPatch: String?,
    val missionPatchSmall: String?,
    val articleLink: String?,
    val youtubeId: String?
)

fun LinksModel.mapToPresentation(): Links {
    return Links(
        missionPatch,
        missionPatchSmall,
        articleLink,
        youtubeId
    )
}