package com.sochato.mates.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.sochato.mates.home.root.HomeNavigator
import com.sochato.mates.profile.root.RootProfileNavigator
import com.sochato.mates.profile.root.ui.RootProfileComponent
import com.sochato.mates.root.RootComponent

class RootProfileNavigatorImpl(
    private val homeNavigator: HomeNavigator,
    private val rootNavigator: RootNavigator
) : RootProfileNavigator {
    override val navigation: StackNavigation<RootProfileComponent.Configuration> = StackNavigation()

    override fun navigateHome() {
        homeNavigator.pop()
    }

    override fun logout() {
        rootNavigator.handleConfiguration(
            RootComponent.Configuration.AuthConfiguration
        )
    }

    override fun handleConfiguration(configuration: RootProfileComponent.Configuration) {
        navigation.bringToFront(configuration)
    }
}