package com.sochato.mates.profile.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.sochato.mates.core.util.base_components.BaseComponent
import com.sochato.mates.core.util.extension.getComponent
import com.sochato.mates.profile.edit_profile.ui.EditProfileComponent
import com.sochato.mates.profile.profile.domain.model.ProfileConfig
import com.sochato.mates.profile.profile.ui.ProfileComponent
import com.sochato.mates.profile.root.RootProfileNavigator
import kotlinx.serialization.Serializable

class RootProfileComponent(
    componentContext: ComponentContext,
    navigator: RootProfileNavigator,
    private val profileConfig: ProfileConfig
) : BaseComponent(componentContext) {

    val childStack = childStack(
        source = navigator.navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.ProfileConfiguration,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: Configuration,
        componentContext: ComponentContext
    ): Child = when (configuration) {
        Configuration.ProfileConfiguration -> {
            Child.ProfileChild(
                getComponent(
                    context = componentContext,
                    param = profileConfig
                )
            )
        }
        Configuration.EditProfileConfiguration -> {
            Child.EditProfileConfiguration(
                getComponent(
                    context = componentContext,
                    param = profileConfig
                )
            )
        }
    }

    sealed class Child {

        internal data class ProfileChild(val component: ProfileComponent) : Child()

        internal data class EditProfileConfiguration(val component: EditProfileComponent): Child()

    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object ProfileConfiguration : Configuration()

        @Serializable
        data object EditProfileConfiguration: Configuration()
    }

}