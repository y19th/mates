package com.sochato.mates.home.main.ui.components.content

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.bars.ShimmedWrummyTopBar
import com.sochato.mates.core.ui.components.inputs.SearchTextField
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.home.main.ui.components.ShimmedNews
import mates.features.home.generated.resources.Res
import mates.features.home.generated.resources.icon_profile
import mates.features.home.generated.resources.main_search_placeholder
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun LoadingContent() {
    WrummyColumn(
        modifier = Modifier
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        topBar = {
            ShimmedWrummyTopBar(
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(24.dp),
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
            onValueChange = {}
        )

        ShimmedNews()
    }
}