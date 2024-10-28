package com.sochato.mates.core.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(
    tableName = "cars",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
@Serializable
data class CarEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val number: NumberEntity,
    val mark: String,
    val model: String
)
