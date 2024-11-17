package com.sochato.mates.core.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import com.sochato.mates.core.local.converters.TransitionConverter
import com.sochato.mates.core.local.dao.GameDao
import com.sochato.mates.core.local.dao.TokenDao
import com.sochato.mates.core.local.dao.TransitionDao
import com.sochato.mates.core.local.dao.UserDao
import com.sochato.mates.core.local.entities.GameEntity
import com.sochato.mates.core.local.entities.TokenEntity
import com.sochato.mates.core.local.entities.TransitionEntity
import com.sochato.mates.core.local.entities.UserEntity


@Database(
    entities = [TransitionEntity::class, UserEntity::class, TokenEntity::class, GameEntity::class],
    version = 1
)
@TypeConverters(TransitionConverter::class)
@ConstructedBy(MainDatabaseConstructor::class)
abstract class MainDatabase : RoomDatabase() {

    abstract fun transitionDao(): TransitionDao

    abstract fun userDao(): UserDao

    abstract fun tokenDao(): TokenDao

    abstract fun gameDao(): GameDao
}


expect object MainDatabaseConstructor : RoomDatabaseConstructor<MainDatabase>
