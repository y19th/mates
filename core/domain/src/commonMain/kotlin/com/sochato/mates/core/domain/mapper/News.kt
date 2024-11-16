package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.data.model.response.NewsItemResponse
import com.sochato.mates.core.domain.models.News
import kotlinx.collections.immutable.toImmutableList

fun List<NewsItemResponse>.toImmutableNewsList() = map { it.toNewsModel() }.toImmutableList()

fun NewsItemResponse.toNewsModel() = News(
    id = id,
    title = title,
    content = content,
    createdAt = createdAt,
    author = author,
    game = game
)