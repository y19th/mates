package com.sochato.mates.profile.external_profile.slot.domain

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface ExternalProfileAbilityEvents: BaseEvents {

    data object OnDismiss: ExternalProfileAbilityEvents
}