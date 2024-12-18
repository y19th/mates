package com.sochato.mates.di

import com.sochato.mates.auth.di.authModule
import com.sochato.mates.auth.root.AuthNavigator
import com.sochato.mates.core.data.di.dataModule
import com.sochato.mates.core.domain.di.domainModule
import com.sochato.mates.home.di.homeModule
import com.sochato.mates.home.root.HomeNavigator
import com.sochato.mates.navigator.AuthNavigatorImpl
import com.sochato.mates.navigator.HomeNavigatorImpl
import com.sochato.mates.navigator.RootNavigator
import com.sochato.mates.navigator.RootNavigatorImpl
import com.sochato.mates.navigator.RootProfileNavigatorImpl
import com.sochato.mates.navigator.SplashNavigatorImpl
import com.sochato.mates.profile.di.profileModule
import com.sochato.mates.profile.root.RootProfileNavigator
import com.sochato.mates.splash.di.splashModule
import com.sochato.mates.splash.root.RootSplashNavigator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val navigatorModule = module {
    singleOf(::RootNavigatorImpl).bind<RootNavigator>()
    singleOf(::SplashNavigatorImpl).bind<RootSplashNavigator>()
    singleOf(::AuthNavigatorImpl).bind<AuthNavigator>()
    singleOf(::HomeNavigatorImpl).bind<HomeNavigator>()
    singleOf(::RootProfileNavigatorImpl).bind<RootProfileNavigator>()
}

val componentModule = module {
    includes(
        splashModule, rootModule, homeModule,
        profileModule, authModule, dataModule, domainModule
    )
}