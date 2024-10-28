package com.sochato.mates.core.local.shared

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.sochato.mates.core.local.database.MainDatabase
import com.sochato.mates.core.util.local.Handler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

actual val databaseBuilder: DatabaseBuilder = IosDatabaseBuilder()

internal class IosDatabaseBuilder: DatabaseBuilder {
    override fun create(path: String): MainDatabase {
        return Room.databaseBuilder<MainDatabase>(
            name = path
        ).fallbackToDestructiveMigrationOnDowngrade(true)
            .setQueryCoroutineContext(Handler.coroutineExceptionHandler + Dispatchers.IO)
            .setDriver(BundledSQLiteDriver())
            .build()
    }

}