package com.sochato.mates.profile.edit_profile.slot.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface EditPhotoEvents: BaseEvents {

    data object OnDismiss: EditPhotoEvents

    data object OnTakePhotoFromGallery: EditPhotoEvents

    data object OnShootPhoto: EditPhotoEvents

    data class OnPhotoTaken(val imageUri: String): EditPhotoEvents
}