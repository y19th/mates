package com.sochato.mates.navigator

import com.sochato.mates.core.util.models.Transition
import com.sochato.mates.root.RootComponent
import com.sochato.mates.splash.ui.SplashNavigator

internal class SplashNavigatorImpl(
    private val rootNavigator: RootNavigator
) : SplashNavigator {
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