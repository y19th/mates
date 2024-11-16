package com.sochato.mates.home.main.ui.components.content

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.inputs.SearchTextField
import com.sochato.mates.core.util.local.MatesSettings
import com.sochato.mates.home.main.domain.events.MainEvents
import com.sochato.mates.home.main.domain.state.MainState
import com.sochato.mates.home.main.ui.components.CollapseState
import com.sochato.mates.home.main.ui.components.CollapsingMainTopBar
import com.sochato.mates.home.main.ui.components.GamesSection
import com.sochato.mates.home.main.ui.components.news.NewsItem
import com.sochato.mates.home.main.ui.components.news.NewsItemTitle
import com.sochato.mates.home.main.ui.components.news.NewsSection
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import mates.features.home.generated.resources.Res
import mates.features.home.generated.resources.main_search_placeholder
import mates.features.home.generated.resources.main_top_bar_title
import mates.features.home.generated.resources.main_top_bar_title_again
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun DataContent(
    isFirstLaunch: Boolean,
    model: MainState,
    handleEvents: (MainEvents) -> Unit
) {
    val state by rememberUpdatedState(model)
    val keys = remember(state.news) { state.news.keys.toImmutableList() }
    val lazyState = rememberLazyListState()

    val collapsed = remember { derivedStateOf { lazyState.firstVisibleItemIndex > 1 } }

    WrummyColumn(
        modifier = Modifier
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        topBar = {
            CollapsingMainTopBar(
                normal = CollapseState.Normal(
                    title = stringResource(
                        resource = if (isFirstLaunch)
                            Res.string.main_top_bar_title else Res.string.main_top_bar_title_again
                    ),
                    content = MatesSettings.nickname
                ),
                collapsed = CollapseState.Collapsed("Лента"),
                isCollapsed = collapsed.value,
                handleEvents = handleEvents
            )
        }
    ) {
        LazyColumn(
            state = lazyState
        ) {
            item {
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
            item {
                GamesSection(
                    items = listOf("2", "3"),
                    handleEvents = handleEvents
                )
            }

            item { NewsSection() }
            item { VerticalSpacer(height = 32.dp) }
            keys.forEach { key ->
                item { NewsItemTitle(key) }
                items(
                    items = state.news.getOrElse(key = key, defaultValue = { persistentListOf() }),
                    key = { it.id },
                    contentType = { it }
                ) { item ->
                    NewsItem(item = item)
                }
            }
        }
    }
}