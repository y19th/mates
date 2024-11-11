package com.sochato.mates.profile.profile.domain.state

import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.util.base_components.BaseState

internal data class ProfileState(
    val model: ProfileModel = ProfileModel()
): BaseState
