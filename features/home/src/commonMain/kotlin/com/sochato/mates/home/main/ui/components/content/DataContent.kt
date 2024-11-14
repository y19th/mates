package com.sochato.mates.home.main.ui.components.content

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.bars.WrummyTopBar
import com.sochato.mates.core.ui.components.inputs.SearchTextField
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.core.util.extension.noIndicationClickable
import com.sochato.mates.core.util.local.MatesSettings
import com.sochato.mates.home.main.domain.events.MainEvents
import mates.features.home.generated.resources.Res
import mates.features.home.generated.resources.icon_profile
import mates.features.home.generated.resources.main_search_placeholder
import mates.features.home.generated.resources.main_top_bar_title
import mates.features.home.generated.resources.main_top_bar_title_again
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun DataContent(
    isFirstLaunch: Boolean,
    model: ProfileModel,
    handleEvents: (MainEvents) -> Unit
) {
    val state = rememberUpdatedState(model)

    WrummyColumn(
        modifier = Modifier
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        topBar = {
            WrummyTopBar(
                title = stringResource(
                    resource = if (isFirstLaunch)
                        Res.string.main_top_bar_title else Res.string.main_top_bar_title_again
                ),
                contentText = MatesSettings.nickname,
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .noIndicationClickable { handleEvents(MainEvents.OnNavigateToProfile) },
                        imageVector = vectorResource(Res.drawable.icon_profile),
                        tint = wrummyColorPalette.homePrimaryColor,
                        contentDescription = "profile icon"
                    )
                }
            )
        }
    ) {
        SearchTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = "",
            placeholder = stringResource(Res.string.main_search_placeholder),
            onValueChange = {
                handleEvents(MainEvents.OnSearchChange(it))
            }
        )
    }
}