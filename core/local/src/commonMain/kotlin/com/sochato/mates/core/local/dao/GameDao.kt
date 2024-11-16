package com.sochato.mates.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sochato.mates.core.local.entities.GameEntity

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: GameEntity)

    @Query("select * from games")
    suspend fun receiveAll(): List<GameEntity>
}