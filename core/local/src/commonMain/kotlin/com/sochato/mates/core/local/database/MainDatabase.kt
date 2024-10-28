package com.sochato.mates.core.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import com.sochato.mates.core.local.converters.TransitionConverter
import com.sochato.mates.core.local.converters.UserConverter
import com.sochato.mates.core.local.dao.CarDao
import com.sochato.mates.core.local.dao.DetailDao
import com.sochato.mates.core.local.dao.TransitionDao
import com.sochato.mates.core.local.dao.UserDao
import com.sochato.mates.core.local.entities.CarEntity
import com.sochato.mates.core.local.entities.DetailItemEntity
import com.sochato.mates.core.local.entities.TransitionEntity
import com.sochato.mates.core.local.entities.UserEntity


@Database(
    entities = [TransitionEntity::class, UserEntity::class, DetailItemEntity::class, CarEntity::class],
    version = 1
)
@TypeConverters(TransitionConverter::class, UserConverter::class)
@ConstructedBy(MainDatabaseConstructor::class)
abstract class MainDatabase : RoomDatabase() {

    abstract fun transitionDao(): TransitionDao

    abstract fun userDao(): UserDao

    abstract fun detailDao(): DetailDao

    abstract fun carDao(): CarDao
}


expect object MainDatabaseConstructor : RoomDatabaseConstructor<MainDatabase>
