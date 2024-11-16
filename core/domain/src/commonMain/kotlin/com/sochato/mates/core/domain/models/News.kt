package com.sochato.mates.core.domain.models

data class News(
    val id: String,
    val title: String,
    val content: String,
    val createdAt: String,
    val author: String,
    val game: String
)
