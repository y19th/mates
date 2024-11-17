package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.data.model.response.GameResponse
import com.sochato.mates.core.domain.models.Game
import com.sochato.mates.core.local.entities.GameEntity
import kotlinx.collections.immutable.toImmutableList

fun GameResponse.toGameEntity() = GameEntity(
    id = id,
    game = game,
    gameTitle = gameTitle,
    playtime = playtime,
    rating = rating,
    lastPlayed = lastPlayed,
    timeAdded = timeAdded
)

fun List<GameResponse>.toImmutableGameModelList() = map { it.toGameModel() }.toImmutableList()

fun GameResponse.toGameModel() = Game(
    id = id,
    game = game,
    gameTitle = gameTitle,
    playtime = playtime,
    rating = rating,
    lastPlayed = lastPlayed,
    timeAdded = timeAdded
)