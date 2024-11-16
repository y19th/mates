package com.sochato.mates.home.main.domain.model

import com.sochato.mates.core.domain.models.News


internal data class MainNews(
    val id: String,
    val title: String,
    val content: String,
    val createdAt: String,
    val author: String,
    val image: String?
)

internal fun News.toMainNews() = MainNews(
    id = id,
    title = title,
    content = content,
    createdAt = createdAt,
    author = author,
    image = image
)
