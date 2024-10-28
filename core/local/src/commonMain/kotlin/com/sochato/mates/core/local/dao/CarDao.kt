package com.sochato.mates.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sochato.mates.core.local.entities.CarEntity

@Dao
interface CarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: CarEntity)


    @Query("select * from cars where userId = :userId")
    suspend fun selectCarByUser(userId: String): List<CarEntity>
}