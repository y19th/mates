package com.sochato.mates.core.local.entities

import kotlinx.serialization.Serializable

@Serializable
data class NumberEntity(
    val mainNumber: String,
    val region: Int
)