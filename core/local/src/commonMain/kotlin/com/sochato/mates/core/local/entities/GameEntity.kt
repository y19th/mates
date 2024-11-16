package com.sochato.mates.core.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey val id: String,
    val game: Int,
    val gameTitle: String,
    val playtime: Int,
    val rating: Int?,
    val lastPlayed: String?,
    val timeAdded: String
)
