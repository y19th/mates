package com.sochato.mates.profile.edit_profile.slot.domain.effect

import com.sochato.mates.core.util.base_components.BaseEffect

internal sealed interface EditPhotoEffect: BaseEffect {

    data object OnOpenGallery: EditPhotoEffect
}