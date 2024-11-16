package com.sochato.mates.home.di

import com.sochato.mates.home.add_game.ui.AddGameComponent
import com.sochato.mates.home.game_detail.ui.DetailGameComponent
import com.sochato.mates.home.main.ui.MainComponent
import com.sochato.mates.home.root.ui.HomeComponent
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val homeModule = module {
    factoryOf(::HomeComponent)
    factoryOf(::MainComponent)
    factoryOf(::AddGameComponent)
    factoryOf(::DetailGameComponent)
}