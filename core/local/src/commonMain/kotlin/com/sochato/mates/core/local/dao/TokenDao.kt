package com.sochato.mates.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sochato.mates.core.local.entities.TokenEntity

@Dao
interface TokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(entity: TokenEntity)

    @Query("select * from token")
    suspend fun get(): TokenEntity?
}