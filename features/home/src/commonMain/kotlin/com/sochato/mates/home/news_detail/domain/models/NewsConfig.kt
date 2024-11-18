package com.sochato.mates.home.news_detail.domain.models

import com.sochato.mates.home.main.domain.model.MainNews
import kotlinx.serialization.Serializable

@Serializable
internal data class NewsConfig(
    val id: String,
    val title: String,
    val content: String,
    val createdAt: String,
    val author: String,
    val image: String?
)

internal fun NewsConfig.toNews() = MainNews(
    id = id,
    title = title,
    content = content,
    createdAt = createdAt,
    author = author,
    image = image
)

internal fun MainNews.toNewsConfig() = NewsConfig(
    id = id,
    title = title,
    content = content,
    createdAt = createdAt,
    author = author,
    image = image
)