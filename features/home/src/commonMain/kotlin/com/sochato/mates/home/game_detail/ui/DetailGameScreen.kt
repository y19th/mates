package com.sochato.mates.home.game_detail.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.buttons.RoundedButton
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import com.sochato.mates.core.util.extension.collectAsImmediateState
import com.sochato.mates.home.game_detail.domain.events.DetailGameEvents
import com.sochato.mates.home.game_detail.ui.components.BackButton
import com.sochato.mates.home.game_detail.ui.components.DetailGameCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun DetailGameScreen(
    component: DetailGameComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    WrummyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .consumeWindowInsets(WindowInsets.systemBars.only(WindowInsetsSides.Top))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            stickyHeader {
                BackButton(
                    onClick = {
                        handleEvents(DetailGameEvents.OnNavigateBack)
                    }
                )

            }
            item(key = state.value.item.id) {
                DetailGameCard(
                    modifier = Modifier
                        .offset { IntOffset(0, -40.dp.roundToPx()) },
                    item = state.value.item
                )
            }
            item {
                VerticalSpacer(height = 32.dp)
            }
            item {
                RoundedButton(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    title = "Добавить игру",
                    onClick = {
                        handleEvents(DetailGameEvents.OnAddGameInProfileLibrary)
                    }
                )
            }
        }
    }
}