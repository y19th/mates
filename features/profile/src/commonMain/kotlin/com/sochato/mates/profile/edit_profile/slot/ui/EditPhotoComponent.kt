package com.sochato.mates.profile.edit_profile.slot.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.util.base_components.EffectComponent
import com.sochato.mates.core.util.models.SnackState
import com.sochato.mates.profile.edit_profile.slot.domain.effect.EditPhotoEffect
import com.sochato.mates.profile.edit_profile.slot.domain.events.EditPhotoEvents
import com.sochato.mates.profile.edit_profile.slot.domain.state.EditPhotoState

internal class EditPhotoComponent(
    componentContext: ComponentContext,
    private val onDismissed: () -> Unit,
    private val updateImage: (String) -> Unit
) : EffectComponent<EditPhotoState, EditPhotoEvents, EditPhotoEffect>(
    initialState = EditPhotoState,
    componentContext = componentContext
) {
    override fun handleEvent(event: EditPhotoEvents) {
        when (event) {
            EditPhotoEvents.OnTakePhotoFromGallery -> {
                sideEffect(EditPhotoEffect.OnOpenGallery)
            }

            EditPhotoEvents.OnShootPhoto -> {
                sideEffect(EditPhotoEffect.OnOpenCamera)
            }

            EditPhotoEvents.OnDismiss -> {
                navigate { onDismissed() }
            }

            is EditPhotoEvents.OnPhotoTaken -> {
                if (event.imageUri.isNotEmpty())
                    updateImage(event.imageUri).also {
                        navigate { onDismissed() }
                    }
                else
                    snackEffect(SnackState.failure("failed to take image"))
            }

        }
    }
}