package com.sochato.mates.di

import com.sochato.mates.navigator.AuthNavigatorImpl
import com.sochato.mates.navigator.RootNavigator
import com.sochato.mates.navigator.RootNavigatorImpl
import com.sochato.mates.navigator.SplashNavigatorImpl
import com.sochato.mates.auth.di.authModule
import com.sochato.mates.auth.root.AuthNavigator
import com.sochato.mates.splash.di.splashModule
import com.sochato.mates.splash.ui.SplashNavigator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val navigatorModule = module {
    singleOf(::RootNavigatorImpl).bind<RootNavigator>()
    singleOf(::SplashNavigatorImpl).bind<SplashNavigator>()
    singleOf(::AuthNavigatorImpl).bind<AuthNavigator>()
}

val componentModule = module {
    includes(splashModule, rootModule, authModule)
}