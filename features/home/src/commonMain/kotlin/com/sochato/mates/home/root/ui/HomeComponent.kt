package com.sochato.mates.home.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.sochato.mates.core.util.base_components.BaseComponent
import com.sochato.mates.core.util.extension.getComponent
import com.sochato.mates.home.main.ui.MainComponent
import com.sochato.mates.home.root.HomeNavigator
import kotlinx.serialization.Serializable

class HomeComponent(
    componentContext: ComponentContext,
    navigator: HomeNavigator
) : BaseComponent(componentContext) {

    val childStack = childStack(
        source = navigator.navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.MainConfiguration,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: Configuration,
        componentContext: ComponentContext
    ): Child = when (configuration) {
        Configuration.MainConfiguration -> {
            Child.MainChild(getComponent(componentContext))
        }
    }


    sealed class Child {

        internal data class MainChild(val component: MainComponent) : Child()

    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object MainConfiguration : Configuration()
    }
}