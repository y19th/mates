package com.sochato.mates.core.local.entities

import com.sochato.mates.core.local.entities.CarEntity
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class ListCarEntity(
    val items: List<CarEntity> = emptyList()
)
