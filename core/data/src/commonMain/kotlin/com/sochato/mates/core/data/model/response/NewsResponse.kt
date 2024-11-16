package com.sochato.mates.core.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsItemResponse(
    val id: String,
    val title: String,
    val content: String,
    @SerialName("created_at") val createdAt: String,
    val author: String,
    val game: String? = null
)
