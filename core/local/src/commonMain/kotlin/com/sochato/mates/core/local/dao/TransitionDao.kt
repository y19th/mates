package com.sochato.mates.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sochato.mates.core.local.entities.TransitionEntity
import com.sochato.mates.core.util.models.Transition

@Dao
interface TransitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(step: TransitionEntity)

    @Query("select step from transition")
    suspend fun receive(): Transition?
}