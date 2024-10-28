package com.sochato.mates.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sochato.mates.core.local.entities.DetailItemEntity

@Dao
interface DetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: DetailItemEntity)

    @Query("select * from details where carId = :carId")
    suspend fun selectDetailsByCar(carId: String): List<DetailItemEntity>
}