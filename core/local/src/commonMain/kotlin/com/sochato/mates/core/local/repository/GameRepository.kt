package com.sochato.mates.core.local.repository

import com.sochato.mates.core.local.dao.GameDao
import com.sochato.mates.core.local.entities.GameEntity

interface GameRepository {

    suspend fun insert(entity: GameEntity)

    suspend fun select(): List<GameEntity>
}

internal class GameRepositoryImpl(
    private val dao: GameDao
): GameRepository {
    override suspend fun insert(entity: GameEntity) {
        dao.insert(entity)
    }

    override suspend fun select(): List<GameEntity> {
        return dao.receiveAll()
    }
}