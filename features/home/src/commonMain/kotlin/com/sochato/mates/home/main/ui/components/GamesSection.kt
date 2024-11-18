package com.sochato.mates.home.main.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.domain.models.LibraryItem
import com.sochato.mates.core.ui.components.HorizontalSpacer
import com.sochato.mates.core.util.shared.rememberScreenWidth
import com.sochato.mates.home.main.domain.events.MainEvents
import com.sochato.mates.home.main.ui.components.game.AddGameItem
import com.sochato.mates.home.main.ui.components.game.GameItem
import kotlinx.collections.immutable.ImmutableList

@Composable
internal fun GamesSection(
    modifier: Modifier = Modifier,
    items: ImmutableList<LibraryItem>,
    handleEvents: (MainEvents) -> Unit
) {
    val carItemWidth = rememberScreenWidth() - 52.dp

    Row(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .horizontalScroll(rememberScrollState())
            .padding(top = 16.dp, bottom = 36.dp)
            .then(modifier)
    ) {
        HorizontalSpacer(width = 16.dp)

        if (items.isNotEmpty()) {
            items.forEach { item ->
                GameItem(
                    modifier = Modifier
                        .width(carItemWidth),
                    image = item.image,
                    title = item.title,
                    onClick = { handleEvents(MainEvents.OnNavigateToDetailGame(item)) }
                )

                HorizontalSpacer(width = 20.dp)
            }
            AddGameItem(
                modifier = Modifier
                    .width(carItemWidth)
                    .fillMaxHeight(),
                onClick = { handleEvents(MainEvents.OnNavigateToAddGame) }
            )

            HorizontalSpacer(width = 16.dp)

        } else {
            AddGameItem(
                modifier = Modifier
                    .width(carItemWidth + 16.dp)
                    .height(138.dp),
                onClick = { handleEvents(MainEvents.OnNavigateToAddGame) }
            )
        }

    }
}