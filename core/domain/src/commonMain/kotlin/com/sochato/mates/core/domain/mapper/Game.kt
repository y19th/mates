package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.data.model.response.GameResponse
import com.sochato.mates.core.domain.models.Game
import com.sochato.mates.core.local.entities.GameEntity
import kotlinx.collections.immutable.toImmutableList
import kotlin.jvm.JvmName

fun GameResponse.toGameEntity() = GameEntity(
    id = id,
    game = game,
    gameTitle = gameTitle,
    playtime = playtime,
    rating = rating,
    lastPlayed = lastPlayed,
    timeAdded = timeAdded
)


fun List<GameResponse>.toGameEntityList() = map { it.toGameEntity() }

@JvmName("GameEntityToImmutableGameModelList")
fun List<GameEntity>.toImmutableGameModelList() = map { it.toGameModel() }.toImmutableList()

@JvmName("GameEntityToGameModel")
fun GameEntity.toGameModel() = Game(
    id = id,
    game = game,
    gameTitle = gameTitle,
    playtime = playtime,
    rating = rating,
    lastPlayed = lastPlayed,
    timeAdded = timeAdded
)

@JvmName("GameResponseToGameModel")
fun GameResponse.toGameModel() = Game(
    id = id,
    game = game,
    gameTitle = gameTitle,
    playtime = playtime,
    rating = rating,
    lastPlayed = lastPlayed,
    timeAdded = timeAdded
)