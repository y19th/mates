package com.sochato.mates.splash.di

import com.sochato.mates.splash.onboarding.ui.OnboardingComponent
import com.sochato.mates.splash.root.ui.RootSplashComponent
import com.sochato.mates.splash.splash.ui.SplashComponent
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val splashModule = module {
    factoryOf(::SplashComponent)
    factoryOf(::RootSplashComponent)
    factoryOf(::OnboardingComponent)
}