package com.sochato.mates.profile.external_profile.domain.state

import com.sochato.mates.core.util.base_components.BaseState
import com.sochato.mates.profile.profile.domain.model.ExternalProfile

internal data class ExternalProfileState(
    val profileInfo: ExternalProfile
): BaseState
