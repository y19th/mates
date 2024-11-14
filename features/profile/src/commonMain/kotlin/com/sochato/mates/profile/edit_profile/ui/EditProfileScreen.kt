package com.sochato.mates.profile.edit_profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.bars.BackNavigationIcon
import com.sochato.mates.core.ui.components.bars.NavigationTopBar
import com.sochato.mates.core.ui.components.buttons.RoundedButton
import com.sochato.mates.core.ui.components.inputs.WrummyTextField
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import com.sochato.mates.core.util.extension.collectAsImmediateState
import com.sochato.mates.profile.edit_profile.domain.effect.EditProfileEffect
import com.sochato.mates.profile.edit_profile.domain.events.EditProfileEvents
import mates.features.profile.generated.resources.Res
import mates.features.profile.generated.resources.edit_profile_desc_placeholder
import mates.features.profile.generated.resources.edit_profile_login_placeholder
import mates.features.profile.generated.resources.icon_default_profile
import mates.features.profile.generated.resources.profile_title
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun EditProfileScreen(
    component: EditProfileComponent,
    onSuccess: (ProfileModel) -> Unit
) {
    val state by component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    LaunchedEffect(Unit) {
        component.sideEffects.collect {
            if (it is EditProfileEffect.OnSuccessEditProfileEffect)
                onSuccess(it.model)
        }
    }

    WrummyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        topBar = {
            NavigationTopBar(
                title = stringResource(resource = Res.string.profile_title),
                navigationIcon = {
                    BackNavigationIcon { handleEvents(EditProfileEvents.OnNavigateBack) }
                }
            )
        }
    ) {
        Image(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape),
            imageVector = vectorResource(Res.drawable.icon_default_profile),
            contentDescription = null
        )


        VerticalSpacer(height = 32.dp)

        WrummyTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.nickname,
            error = state.isNicknameError,
            placeholder = stringResource(Res.string.edit_profile_login_placeholder),
            onValueChange = {
                handleEvents(EditProfileEvents.OnNicknameChange(it))
            }
        )

        VerticalSpacer(height = 16.dp)

        WrummyTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.status,
            placeholder = stringResource(Res.string.edit_profile_desc_placeholder),
            onValueChange = {
                handleEvents(EditProfileEvents.OnStatusChange(it))
            }
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        RoundedButton(
            title = "Сохранить",
            onClick = { handleEvents(EditProfileEvents.OnValidate) }
        )
    }
}