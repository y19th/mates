package com.sochato.mates.core.domain.models

data class Game(
    val id: String,
    val game: Int,
    val gameTitle: String,
    val playtime: Int,
    val rating: Int?,
    val lastPlayed: String?,
    val timeAdded: String
)
