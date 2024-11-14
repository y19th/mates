package com.sochato.mates.profile.edit_profile.domain.effect

import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.util.base_components.BaseEffect

internal sealed interface EditProfileEffect: BaseEffect {

    data class OnSuccessEditProfileEffect(
        val model: ProfileModel
    ): EditProfileEffect
}