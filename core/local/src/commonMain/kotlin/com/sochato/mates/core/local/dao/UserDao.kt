package com.sochato.mates.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sochato.mates.core.local.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(entity: UserEntity)

    @Query("select * from user")
    suspend fun receiveUserEntity(): UserEntity?

    @Query("delete from user")
    suspend fun deleteUser()
}