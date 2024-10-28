package com.sochato.mates.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.sochato.mates.auth.root.AuthNavigator
import com.sochato.mates.auth.root.ui.AuthComponent

class AuthNavigatorImpl(
    private val rootNavigator: RootNavigator
): AuthNavigator {

    override val navigation: StackNavigation<AuthComponent.Configuration>
        = StackNavigation()

    override fun navigateHome() {
       // rootNavigator.handleConfiguration(RootComponent.Configuration.HomeConfiguration)
    }

    override fun handleConfiguration(configuration: AuthComponent.Configuration) {
        navigation.bringToFront(configuration)
    }
}