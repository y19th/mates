package com.sochato.mates.core.domain.models

data class LibraryItem(
    val id: Int,
    val title: String,
    val description: String,
    val publisher: String,
    val releaseDate: String,
    val platforms: List<String>,
    val genres: List<String>
)
