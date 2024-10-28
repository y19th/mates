package com.sochato.mates.core.local.repository

import com.sochato.mates.core.local.dao.UserDao
import com.sochato.mates.core.local.entities.UserEntity

interface UserRepository {

    suspend fun updateUser(entity: UserEntity)

    suspend fun receiveUserEntity(): UserEntity?
}

internal class UserRepositoryImpl(
    private val dao: UserDao
): UserRepository {

    override suspend fun updateUser(entity: UserEntity) {
        dao.updateUser(entity)
    }

    override suspend fun receiveUserEntity(): UserEntity? {
        return dao.receiveUserEntity()
    }
}