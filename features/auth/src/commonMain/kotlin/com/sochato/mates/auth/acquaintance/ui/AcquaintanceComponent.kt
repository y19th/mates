package com.sochato.mates.auth.acquaintance.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.auth.acquaintance.domain.events.AcquaintanceEvents
import com.sochato.mates.auth.acquaintance.domain.state.AcquaintanceState
import com.sochato.mates.auth.root.AuthNavigator
import com.sochato.mates.core.util.base_components.ScreenComponent

internal class AcquaintanceComponent(
    componentContext: ComponentContext,
    private val navigator: AuthNavigator
) : ScreenComponent<AcquaintanceState, AcquaintanceEvents>(
    initialState = AcquaintanceState(),
    componentContext = componentContext
) {
    override fun handleEvent(event: AcquaintanceEvents) {
        when (event) {
            is AcquaintanceEvents.OnNameChange -> {
                update { it.copy(name = event.newValue) }
            }

            AcquaintanceEvents.OnProceed -> {
                if (state.value.name.isNotEmpty()) {
                }
            }
        }
    }
}