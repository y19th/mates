package com.sochato.mates.profile.external_profile.slot.domain

import com.sochato.mates.core.util.base_components.BaseState
import com.sochato.mates.profile.profile.domain.model.ExternalProfile

internal data class ExternalProfileAbilityState(
    val profile: ExternalProfile,
): BaseState