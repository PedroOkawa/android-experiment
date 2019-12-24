package me.okawa.androidexperiment.model

import me.okawa.domain.model.LinksModel

data class Links(
    val missionPatch: String,
    val missionPatchSmall: String,
    val articleLink: String,
    val youtubeId: String
)

fun LinksModel.mapToPresentation(): Links {
    return Links(
        missionPatch,
        missionPatchSmall,
        articleLink,
        youtubeId
    )
}