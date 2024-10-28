package com.sochato.mates

import com.sochato.mates.core.local.shared.databaseBuilder
import com.sochato.mates.di.initKoin
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.dsl.module
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask


fun initKoin() {
    initKoin(
        additionalModules = module {
            single { databaseBuilder.create(documentDirectory() + "/database.db") }
        }
    )
}

@OptIn(ExperimentalForeignApi::class)
fun documentDirectory(isCaching: Boolean = false): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = if (isCaching) NSCachesDirectory else NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}

