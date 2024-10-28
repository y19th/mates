package com.sochato.mates.auth.acquaintance.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface AcquaintanceEvents: BaseEvents {

    data object OnProceed: AcquaintanceEvents

    data class OnNameChange(val newValue: String): AcquaintanceEvents
}