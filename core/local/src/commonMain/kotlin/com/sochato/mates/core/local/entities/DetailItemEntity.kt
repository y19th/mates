package com.sochato.mates.core.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.sochato.mates.core.local.entities.CarEntity
import kotlinx.serialization.Serializable

@Entity(
    tableName = "details",
    foreignKeys = [
        ForeignKey(
            entity = CarEntity::class,
            parentColumns = ["id"],
            childColumns = ["carId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
@Serializable
data class DetailItemEntity(
    @PrimaryKey val id: String,
    val carId: String,
    val name: String,
    val icon: String,
    val color: String,
    val mileage: Int,
    val millis: Long
)
