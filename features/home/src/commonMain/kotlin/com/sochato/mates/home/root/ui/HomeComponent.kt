package com.sochato.mates.home.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.sochato.mates.core.util.base_components.BaseComponent
import com.sochato.mates.core.util.extension.getComponent
import com.sochato.mates.home.add_game.ui.AddGameComponent
import com.sochato.mates.home.game_detail.domain.models.LibraryConfig
import com.sochato.mates.home.game_detail.ui.DetailGameComponent
import com.sochato.mates.home.main.ui.MainComponent
import com.sochato.mates.home.root.HomeNavigator
import com.sochato.mates.profile.profile.domain.model.ProfileConfig
import com.sochato.mates.profile.root.ui.RootProfileComponent
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

        Configuration.AddGameConfiguration -> {
            Child.AddGameChild(getComponent(componentContext))
        }

        is Configuration.ProfileConfiguration -> {
            Child.ProfileChild(
                getComponent(
                    context = componentContext,
                    param = configuration.config
                )
            )
        }

        is Configuration.DetailGameConfiguration -> {
            Child.DetailGameChild(
                getComponent(
                    context = componentContext,
                    params = arrayOf(configuration.item, configuration.isAlreadyAdded)
                )
            )
        }
    }


    sealed class Child {

        internal data class MainChild(val component: MainComponent) : Child()

        internal data class AddGameChild(val component: AddGameComponent): Child()

        internal data class ProfileChild(val component: RootProfileComponent) : Child()

        internal data class DetailGameChild(val component: DetailGameComponent) : Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object MainConfiguration : Configuration()

        @Serializable
        data object AddGameConfiguration: Configuration()

        @Serializable
        internal data class DetailGameConfiguration(
            val item: LibraryConfig,
            val isAlreadyAdded: Boolean
        ): Configuration()

        @Serializable
        data class ProfileConfiguration(
            val config: ProfileConfig
        ) : Configuration()
    }
}