package com.sochato.mates.core.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "token")
data class TokenEntity(
    @PrimaryKey val id: Int = 52,
    val access: String,
    val refresh: String
)
