package com.sochato.mates.core.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameResponse(
    val id: String,
    val game: Int,
    @SerialName("game_title") val gameTitle: String,
    @SerialName("playtime_hours") val playtime: Int,
    val rating: Int?,
    @SerialName("last_played") val lastPlayed: String?,
    @SerialName("added_at") val timeAdded: String
)
