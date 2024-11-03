package com.sochato.mates.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.sochato.mates.home.root.HomeNavigator
import com.sochato.mates.home.root.ui.HomeComponent

internal class HomeNavigatorImpl: HomeNavigator {
    override val navigation: StackNavigation<HomeComponent.Configuration>
        = StackNavigation()

    override fun handleConfiguration(configuration: HomeComponent.Configuration) {
        navigation.bringToFront(configuration)
    }
}