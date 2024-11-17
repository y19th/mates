package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.data.model.response.LibraryItemResponse
import com.sochato.mates.core.domain.models.LibraryItem
import kotlinx.collections.immutable.toImmutableList

fun List<LibraryItemResponse>.toImmutableLibraryItemModelList() =
    map { it.toLibraryItemModel() }.toImmutableList()

fun LibraryItemResponse.toLibraryItemModel() = LibraryItem(
    id = id,
    title = title,
    description = description,
    publisher = publisher,
    releaseDate = releaseDate,
    platforms = platforms,
    genres = genres,
    image = image
)