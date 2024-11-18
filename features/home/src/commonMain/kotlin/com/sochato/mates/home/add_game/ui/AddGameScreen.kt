package com.sochato.mates.home.add_game.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.bars.BackNavigationIcon
import com.sochato.mates.core.ui.components.bars.NavigationTopBar
import com.sochato.mates.core.ui.components.inputs.SearchTextField
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import com.sochato.mates.core.util.extension.collectAsImmediateState
import com.sochato.mates.home.add_game.domain.events.AddGameEvents
import com.sochato.mates.home.main.ui.components.game.GameItem
import mates.features.home.generated.resources.Res
import mates.features.home.generated.resources.main_search_placeholder
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddGameScreen(
    component: AddGameComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    LaunchedEffect(Unit) {
        handleEvents(AddGameEvents.OnRefreshProfileLibrary)
    }

    WrummyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 16.dp),
        topBar = {
            NavigationTopBar(
                title = "Найти игру",
                navigationIcon = {
                    BackNavigationIcon { handleEvents(AddGameEvents.OnNavigateBack) }
                }
            )
        }
    ) {
        LazyColumn {
            item { VerticalSpacer(height = 12.dp) }
            item {
                SearchTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = state.value.search,
                    placeholder = stringResource(Res.string.main_search_placeholder),
                    onValueChange = {
                        handleEvents(AddGameEvents.OnSearchChanged(it))
                    }
                )
            }
            item { VerticalSpacer(height = 28.dp) }

            item {
                TextSemibold(
                    text = "Ваши игры",
                    fontSize = 20.sp,
                    color = wrummyColorPalette.primaryTextColor
                )
            }

            item { VerticalSpacer(height = 20.dp) }

            items(
                items = state.value.profileLibrary,
                key = { it.id.plus(100) }
            ) { item ->
                GameItem(
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    image = item.image,
                    title = item.title,
                    onClick = {
                        handleEvents(AddGameEvents.OnNavigateToDetail(item))
                    }
                )
            }

            item { VerticalSpacer(height = 20.dp) }

            item {
                TextSemibold(
                    text = "Список игр",
                    fontSize = 20.sp,
                    color = wrummyColorPalette.primaryTextColor
                )
            }
            item { VerticalSpacer(height = 20.dp) }
            items(
                items = state.value.library,
                key = { it.id }
            ) { item ->
                GameItem(
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    image = item.image,
                    title = item.title,
                    onClick = {
                        handleEvents(AddGameEvents.OnNavigateToDetail(item))
                    }
                )
            }
        }
    }
}