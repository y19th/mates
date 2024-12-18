package com.sochato.mates.profile.profile.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.bars.BackNavigationIcon
import com.sochato.mates.core.ui.components.bars.NavigationTopBar
import com.sochato.mates.core.ui.components.buttons.RoundedButton
import com.sochato.mates.core.ui.components.texts.TextBold
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import com.sochato.mates.core.util.extension.collectAsImmediateState
import com.sochato.mates.core.util.extension.noIndicationClickable
import com.sochato.mates.profile.profile.domain.events.ProfileEvents
import com.sochato.mates.profile.profile.ui.components.ProfileAsyncIcon
import com.sochato.mates.profile.profile.ui.components.ProfileButton
import mates.features.profile.generated.resources.Res
import mates.features.profile.generated.resources.ic_friends
import mates.features.profile.generated.resources.ic_gear
import mates.features.profile.generated.resources.icon_games
import mates.features.profile.generated.resources.icon_mates_points
import mates.features.profile.generated.resources.profile_library
import mates.features.profile.generated.resources.profile_mates_header
import mates.features.profile.generated.resources.profile_mates_points
import mates.features.profile.generated.resources.profile_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProfileScreen(
    component: ProfileComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    LaunchedEffect(Unit) {
        handleEvents(ProfileEvents.OnRefresh)
    }

    WrummyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        topBar = {
            NavigationTopBar(
                title = stringResource(resource = Res.string.profile_title),
                navigationIcon = {
                    BackNavigationIcon { handleEvents(ProfileEvents.OnNavigateBack) }
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .noIndicationClickable { handleEvents(ProfileEvents.OnNavigateToEdit) },
                        painter = painterResource(Res.drawable.ic_gear),
                        contentDescription = null
                    )
                }
            )
        }
    ) {
        ProfileAsyncIcon(
            url = state.value.model.pictureUrl
        )

        VerticalSpacer(height = 8.dp)

        TextBold(
            text = state.value.model.nickname,
            fontSize = 24.sp,
            lineHeight = 36.sp,
            color = wrummyColorPalette.homePrimaryColor
        )

        VerticalSpacer(height = 2.dp)

        TextRegular(
            text = state.value.model.profileDescription,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            color = wrummyColorPalette.profileSecondaryColor
        )

        VerticalSpacer(height = 32.dp)

        ProfileButton(
            image = Res.drawable.ic_friends,
            title = stringResource(Res.string.profile_mates_header),
            onClick = {
                handleEvents(ProfileEvents.OnNavigateToMates)
            }
        )

        VerticalSpacer(height = 16.dp)

        ProfileButton(
            image = Res.drawable.icon_games,
            title = stringResource(Res.string.profile_library),
            onClick = {}
        )

        VerticalSpacer(height = 16.dp)

        ProfileButton(
            image = Res.drawable.icon_mates_points,
            title = stringResource(Res.string.profile_mates_points),
            onClick = {}
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        RoundedButton(
            title = "Выйти",
            onClick = {
                handleEvents(ProfileEvents.OnLogout)
            }
        )
    }
}