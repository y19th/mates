package com.sochato.mates.core.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LibraryItemResponse(
    val id: Int,
    val title: String,
    val description: String,
    val publisher: String,
    @SerialName("release_data") val releaseDate: String,
    val platforms: List<String>,
    val genres: List<String>
)