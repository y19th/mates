package com.sochato.mates.di

import com.sochato.mates.root.RootComponent
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val rootModule = module {
    singleOf(::RootComponent)
}