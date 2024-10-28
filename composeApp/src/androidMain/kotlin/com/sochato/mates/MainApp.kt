package com.sochato.mates

import android.app.Application
import android.content.Context
import com.sochato.mates.core.local.shared.databaseBuilder
import com.sochato.mates.di.initKoin
import org.koin.dsl.module

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(
            additionalModules = module {
                single<Context> { this@MainApp }
                single {
                    databaseBuilder.create("${applicationContext.filesDir}/database.db")
                }
            }
        )
    }
}