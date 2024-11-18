package com.sochato.mates.profile.external_profile.slot.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.ui.components.ModalSheetButton
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.buttons.RoundedButton
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import com.sochato.mates.core.util.extension.collectAsImmediateState
import com.sochato.mates.profile.external_profile.slot.domain.ExternalProfileAbilityEvents
import mates.features.profile.generated.resources.Res
import mates.features.profile.generated.resources.icon_message
import mates.features.profile.generated.resources.icon_report
import org.jetbrains.compose.resources.vectorResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ExternalProfileAbilityScreen(
    component: ExternalProfileAbilityComponent
) {
    val state by component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    ModalBottomSheet(
        containerColor = Color.White,
        onDismissRequest = {
            handleEvents(ExternalProfileAbilityEvents.OnDismiss)
        },
        contentWindowInsets = { WindowInsets.systemBars.only(WindowInsetsSides.Bottom) }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
        ) {
            VerticalSpacer(height = 16.dp)

            ModalSheetButton(
                title = "Написать сообщение",
                icon = vectorResource(Res.drawable.icon_message),
                onClick = {
                    //handleEvents(ExternalProfileAbilityEvents)
                }
            )

            VerticalSpacer(height = 16.dp)

            ModalSheetButton(
                title = "Пожаловаться",
                icon = vectorResource(Res.drawable.icon_report),
                onClick = {
                    //handleEvents(EditPhotoEvents.OnShootPhoto)
                }
            )

            if(state.profile.isFriend) {
                VerticalSpacer(height = 64.dp)

                RoundedButton(
                    title = "Удалить из mates",
                    onClick = {

                    }
                )
            }

            VerticalSpacer(height = 24.dp)
        }

    }
}