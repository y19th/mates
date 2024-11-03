package com.sochato.mates.home.di

import com.sochato.mates.home.main.ui.MainComponent
import com.sochato.mates.home.root.ui.HomeComponent
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val homeModule = module {
    factoryOf(::HomeComponent)
    factoryOf(::MainComponent)
}