package com.sochato.mates.core.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Entity(tableName = "user")
data class UserEntity @OptIn(ExperimentalUuidApi::class) constructor(
    @PrimaryKey val id: String = Uuid.random().toString(),
    val name: String = ""
)
