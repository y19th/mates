package com.sochato.mates.home.news_detail.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import com.sochato.mates.core.util.extension.collectAsImmediateState
import com.sochato.mates.home.game_detail.ui.components.BackButton
import com.sochato.mates.home.news_detail.domain.events.DetailNewsEvents
import com.sochato.mates.home.news_detail.ui.components.DetailNewsCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun DetailNewsScreen(
    component: DetailNewsComponent
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
                        handleEvents(DetailNewsEvents.OnNavigateBack)
                    }
                )

            }
            item(key = state.value.item.id) {
                DetailNewsCard(
                    modifier = Modifier
                        .offset { IntOffset(0, -40.dp.roundToPx()) },
                    item = state.value.item
                )
            }
            item {
                VerticalSpacer(height = 32.dp)
            }
        }
    }

}