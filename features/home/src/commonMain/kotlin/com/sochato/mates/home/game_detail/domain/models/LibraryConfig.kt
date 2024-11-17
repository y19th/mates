package com.sochato.mates.home.game_detail.domain.models

import com.sochato.mates.core.domain.models.LibraryItem
import kotlinx.serialization.Serializable

@Serializable
internal data class LibraryConfig(
    val id: Int,
    val title: String,
    val description: String,
    val publisher: String,
    val releaseDate: String,
    val image: String?,
    val platforms: List<String>,
    val genres: List<String>
)

internal fun LibraryItem.toLibraryConfig() = LibraryConfig(
    id = id,
    title = title,
    description = description,
    publisher = publisher,
    releaseDate = releaseDate,
    platforms = platforms,
    genres = genres,
    image = image
)

internal fun LibraryConfig.toLibraryItem() = LibraryItem(
    id = id,
    title = title,
    description = description,
    publisher = publisher,
    releaseDate = releaseDate,
    platforms = platforms,
    genres = genres,
    image = image
)
