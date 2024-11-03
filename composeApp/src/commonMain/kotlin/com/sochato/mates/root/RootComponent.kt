package com.sochato.mates.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.sochato.mates.auth.root.ui.AuthComponent
import com.sochato.mates.core.util.base_components.BaseComponent
import com.sochato.mates.core.util.extension.getComponent
import com.sochato.mates.home.root.ui.HomeComponent
import com.sochato.mates.navigator.RootNavigator
import com.sochato.mates.splash.root.ui.RootSplashComponent
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext,
    navigator: RootNavigator
): BaseComponent(componentContext) {

    val childStack = childStack(
        source = navigator.navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.SplashConfiguration,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: Configuration,
        context: ComponentContext
    ): Child = when(configuration) {
        Configuration.SplashConfiguration -> {
            Child.SplashChild(getComponent(context))
        }

        Configuration.AuthConfiguration -> {
            Child.AuthChild(getComponent(context))
        }

        Configuration.HomeConfiguration -> {
            Child.HomeChild(getComponent(context))
        }
    }


    sealed class Child {

        data class SplashChild(val component: RootSplashComponent): Child()

        data class AuthChild(val component: AuthComponent): Child()

        data class HomeChild(val component: HomeComponent): Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object SplashConfiguration: Configuration()

        @Serializable
        data object AuthConfiguration: Configuration()

        @Serializable
        data object HomeConfiguration: Configuration()
    }
}