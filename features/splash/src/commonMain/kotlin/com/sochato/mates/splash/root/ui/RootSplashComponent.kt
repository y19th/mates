package com.sochato.mates.splash.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.sochato.mates.core.util.base_components.BaseComponent
import com.sochato.mates.core.util.extension.getComponent
import com.sochato.mates.splash.onboarding.ui.OnboardingComponent
import com.sochato.mates.splash.root.RootSplashNavigator
import com.sochato.mates.splash.splash.ui.SplashComponent
import kotlinx.serialization.Serializable

class RootSplashComponent(
    componentContext: ComponentContext,
    navigator: RootSplashNavigator
) : BaseComponent(componentContext) {

    val childStack = childStack(
        source = navigator.navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.SplashConfiguration,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: Configuration,
        componentContext: ComponentContext
    ) = when (configuration) {
        Configuration.OnboardingConfiguration -> {
            Child.OnboardingChild(getComponent(componentContext))
        }

        Configuration.SplashConfiguration -> {
            Child.SplashChild(getComponent(componentContext))
        }
    }

    sealed class Child {

        internal data class SplashChild(val component: SplashComponent) : Child()

        internal data class OnboardingChild(val component: OnboardingComponent) : Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object SplashConfiguration : Configuration()

        @Serializable
        data object OnboardingConfiguration : Configuration()
    }
}