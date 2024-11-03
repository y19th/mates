package com.sochato.mates.core.local.repository

import com.sochato.mates.core.local.dao.TokenDao
import com.sochato.mates.core.local.entities.TokenEntity

interface TokenRepository {

    suspend fun insert(entity: TokenEntity)

    suspend fun get(): TokenEntity
}

internal class TokenRepositoryImpl(
    private val dao: TokenDao
) : TokenRepository {
    override suspend fun insert(entity: TokenEntity) {
        dao.update(entity)
    }

    override suspend fun get(): TokenEntity {
        return dao.get()
    }
}