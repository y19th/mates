package com.sochato.mates.profile.edit_profile.slot.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.ui.components.ModalSheetButton
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import com.sochato.mates.profile.edit_profile.slot.domain.effect.EditPhotoEffect
import com.sochato.mates.profile.edit_profile.slot.domain.events.EditPhotoEvents
import com.sochato.mates.profile.shared.PickPhoto
import com.sochato.mates.profile.shared.TakePhoto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun EditPhotoScreen(
    component: EditPhotoComponent
) {
    val state = rememberModalBottomSheetState()
    val handleEvents = component.rememberHandleEvents()
    val isPickerVisible = remember { mutableStateOf(false) }
    val isCameraVisible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        component.sideEffects.collect {
            when (it) {
                EditPhotoEffect.OnOpenCamera -> {
                    isCameraVisible.value = !isCameraVisible.value
                }

                EditPhotoEffect.OnOpenGallery -> {
                    isPickerVisible.value = !isPickerVisible.value
                }

                null -> {
                    Unit
                }
            }
        }
    }

    if (isPickerVisible.value)
        PickPhoto {
            handleEvents(EditPhotoEvents.OnPhotoTaken(it))
            isPickerVisible.value = false
        }
    if (isCameraVisible.value)
        TakePhoto {
            handleEvents(EditPhotoEvents.OnPhotoTaken(it))
            isCameraVisible.value = false
        }


    ModalBottomSheet(
        sheetState = state,
        containerColor = Color.White,
        onDismissRequest = {
            handleEvents(EditPhotoEvents.OnDismiss)
        },
        contentWindowInsets = { WindowInsets.systemBars.only(WindowInsetsSides.Bottom) }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
        ) {
            VerticalSpacer(height = 16.dp)

            ModalSheetButton(
                title = "Выбрать из галереи",
                icon = Icons.Default.Image,
                onClick = {
                    handleEvents(EditPhotoEvents.OnTakePhotoFromGallery)
                }
            )

            VerticalSpacer(height = 16.dp)

            ModalSheetButton(
                title = "Сделать фото",
                icon = Icons.Default.PhotoCamera,
                onClick = {
                    handleEvents(EditPhotoEvents.OnShootPhoto)
                }
            )

            VerticalSpacer(height = 24.dp)
        }
    }
}