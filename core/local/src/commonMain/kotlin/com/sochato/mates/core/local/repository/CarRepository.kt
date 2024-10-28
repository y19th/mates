package com.sochato.mates.core.local.repository

import com.sochato.mates.core.local.dao.CarDao
import com.sochato.mates.core.local.entities.CarEntity

interface CarRepository {

    suspend fun insert(entity: CarEntity)

    suspend fun selectByCar(userId: String): List<CarEntity>
}

internal class CarRepositoryImpl(
    private val dao: CarDao
): CarRepository {
    override suspend fun insert(entity: CarEntity) {
        dao.insert(entity)
    }

    override suspend fun selectByCar(userId: String): List<CarEntity> {
        return dao.selectCarByUser(userId)
    }
}