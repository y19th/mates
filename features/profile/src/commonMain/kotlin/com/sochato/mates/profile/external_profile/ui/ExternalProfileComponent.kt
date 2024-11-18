package com.sochato.mates.profile.external_profile.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.value.Value
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.profile.external_profile.domain.events.ExternalProfileEvents
import com.sochato.mates.profile.external_profile.domain.state.ExternalProfileState
import com.sochato.mates.profile.external_profile.slot.ui.ExternalProfileAbilityComponent
import com.sochato.mates.profile.profile.domain.model.ExternalProfileConfig
import com.sochato.mates.profile.profile.domain.model.toExternalProfile
import com.sochato.mates.profile.root.RootProfileNavigator
import kotlinx.serialization.Serializable

internal class ExternalProfileComponent(
    componentContext: ComponentContext,
    config: ExternalProfileConfig,
    private val navigator: RootProfileNavigator
) : ScreenComponent<ExternalProfileState, ExternalProfileEvents>(
    initialState = ExternalProfileState(profileInfo = config.toExternalProfile()),
    componentContext = componentContext
) {
    private val dialogNavigation = SlotNavigation<DialogConfiguration>()
    val dialog: Value<ChildSlot<*, ExternalProfileAbilityComponent>> = childSlot(
        source = dialogNavigation,
        serializer = DialogConfiguration.serializer(),
        handleBackButton = true
    ) { _, childComponentContext ->
        ExternalProfileAbilityComponent(
            componentContext = childComponentContext,
            profile = state.value.profileInfo,
            onDismissed = dialogNavigation::dismiss,
        )
    }

    override fun handleEvent(event: ExternalProfileEvents) {
        when (event) {
            ExternalProfileEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            ExternalProfileEvents.OnOpenSheet -> {
                dialogNavigation.activate(DialogConfiguration)
            }

            ExternalProfileEvents.OnNavigateToMates -> {
                //TODO()
            }

            ExternalProfileEvents.OnRefresh -> {
                //TODO()
            }
        }
    }

    @Serializable
    private data object DialogConfiguration
}