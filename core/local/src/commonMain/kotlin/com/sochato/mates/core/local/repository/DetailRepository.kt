package com.sochato.mates.core.local.repository

import com.sochato.mates.core.local.dao.DetailDao
import com.sochato.mates.core.local.entities.DetailItemEntity

interface DetailRepository {

    suspend fun insert(entity: DetailItemEntity)

    suspend fun selectByCar(carId: String): List<DetailItemEntity>
}

internal class DetailRepositoryImpl(
    private val dao: DetailDao
): DetailRepository {
    override suspend fun insert(entity: DetailItemEntity) {
        dao.insert(entity)
    }

    override suspend fun selectByCar(carId: String): List<DetailItemEntity> {
        return dao.selectDetailsByCar(carId)
    }
}