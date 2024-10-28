package com.sochato.mates.core.local.repository

import com.sochato.mates.core.local.dao.TransitionDao
import com.sochato.mates.core.local.entities.TransitionEntity
import com.sochato.mates.core.util.models.Transition

interface TransitionRepository {

    suspend fun update(entity: TransitionEntity)

    suspend fun receive(): Transition
}

internal class TransitionRepositoryImpl(
    private val dao: TransitionDao
): TransitionRepository {
    override suspend fun update(entity: TransitionEntity) {
        dao.insert(entity)
    }

    override suspend fun receive(): Transition {
        return dao.receive() ?: Transition.None
    }
}