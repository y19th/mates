package com.sochato.mates.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.navigate
import com.sochato.mates.core.util.models.Transition
import com.sochato.mates.root.RootComponent
import com.sochato.mates.splash.root.RootSplashNavigator
import com.sochato.mates.splash.root.ui.RootSplashComponent

internal class SplashNavigatorImpl(
    private val rootNavigator: RootNavigator
) : RootSplashNavigator {

    override val navigation: StackNavigation<RootSplashComponent.Configuration>
        = StackNavigation()

    override fun handleConfiguration(configuration: RootSplashComponent.Configuration) {
        navigation.navigate { listOf(configuration) }
    }

    override fun navigate(transition: Transition) {
        when(transition) {
            Transition.Authorized -> {
                //TODO
            }
            Transition.None -> {
                rootNavigator.handleConfiguration(
                    RootComponent.Configuration.AuthConfiguration
                )
            }
        }
    }
}