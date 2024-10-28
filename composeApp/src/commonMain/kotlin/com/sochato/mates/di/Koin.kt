package com.sochato.mates.di

import com.sochato.mates.core.domain.di.domainModule
import com.sochato.mates.core.local.di.roomModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(additionalModules: Module): KoinApplication {
    return startKoin {
        modules(
            additionalModules,
            navigatorModule,
            componentModule,
            roomModule,
            domainModule
        )
    }
}
