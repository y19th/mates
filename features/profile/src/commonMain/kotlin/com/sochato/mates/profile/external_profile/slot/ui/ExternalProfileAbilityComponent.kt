package com.sochato.mates.profile.external_profile.slot.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.profile.external_profile.slot.domain.ExternalProfileAbilityEvents
import com.sochato.mates.profile.external_profile.slot.domain.ExternalProfileAbilityState
import com.sochato.mates.profile.profile.domain.model.ExternalProfile

internal class ExternalProfileAbilityComponent(
    componentContext: ComponentContext,
    profile: ExternalProfile,
    private val onDismissed: () -> Unit
) : ScreenComponent<ExternalProfileAbilityState, ExternalProfileAbilityEvents>(
    initialState = ExternalProfileAbilityState(profile),
    componentContext = componentContext
) {
    override fun handleEvent(event: ExternalProfileAbilityEvents) {
        when (event) {
            ExternalProfileAbilityEvents.OnDismiss -> {
                navigate { onDismissed() }
            }
        }
    }
}