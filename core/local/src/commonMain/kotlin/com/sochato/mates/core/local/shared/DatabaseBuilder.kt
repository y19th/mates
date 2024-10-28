package com.sochato.mates.core.local.shared

import com.sochato.mates.core.local.database.MainDatabase

interface DatabaseBuilder {
    fun create(path: String): MainDatabase
}

expect val databaseBuilder: DatabaseBuilder