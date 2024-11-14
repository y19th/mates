package com.sochato.mates.core.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val uid: String,
    val email: String = "",
    val nickname: String = "",
    val matesPoints: Int = 0,
    val registrationDate: String = "",
    val profileDescription: String = "",
    val status: String = "",
    val pictureUrl: String? = null
)
