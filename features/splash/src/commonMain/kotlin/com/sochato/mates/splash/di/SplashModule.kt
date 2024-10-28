package com.sochato.mates.splash.di

import com.sochato.mates.splash.ui.SplashComponent
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val splashModule = module {
    factoryOf(::SplashComponent)
}