package com.sochato.mates.home.main.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.bars.CollapsingMatesTopBar
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.core.util.extension.noIndicationClickable
import com.sochato.mates.home.main.domain.events.MainEvents
import mates.features.home.generated.resources.Res
import mates.features.home.generated.resources.icon_profile
import org.jetbrains.compose.resources.vectorResource


internal sealed interface CollapseState {

    data class Collapsed(val text: String): CollapseState

    data class Normal(val title: String, val content: String): CollapseState
}

@Composable
internal fun CollapsingMainTopBar(
    normal: CollapseState.Normal,
    collapsed: CollapseState.Collapsed,
    isCollapsed: Boolean = false,
    handleEvents: (MainEvents) -> Unit
) {
    CollapsingMatesTopBar(
        isCollapsed = isCollapsed,
        uncollapsedContent = {
            TextRegular(
                text = normal.title,
                color = wrummyColorPalette.homePrimaryColor,
                fontSize = 12.sp,
                maxLines = 1
            )
            TextSemibold(
                text = normal.content,
                color = wrummyColorPalette.homePrimaryColor,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        collapsedContent = {
            TextSemibold(
                text = collapsed.text,
                fontSize = 20.sp,
                lineHeight = 32.sp
            )
        },
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