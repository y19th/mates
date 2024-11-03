package com.sochato.mates.home.main.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.saveable.rememberSaveable
import com.sochato.mates.core.ui.ErrorContent
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import com.sochato.mates.core.util.local.MatesSettings
import com.sochato.mates.home.main.domain.events.MainEvents
import com.sochato.mates.home.main.domain.state.MainState
import com.sochato.mates.home.main.ui.components.content.DataContent
import com.sochato.mates.home.main.ui.components.content.LoadingContent

@Composable
internal fun MainScreen(
    component: MainComponent
) {
    val state = component.state.collectAsState()
    val handleEvents = component.rememberHandleEvents()
    val isFirst = rememberSaveable { MatesSettings.firstHomeLaunch }

    LaunchedEffect(Unit) {
        if (isFirst)
            handleEvents(MainEvents.OnFirstLaunch)
    }

    when (val instance = state.value) {
        is MainState.Data -> {
            DataContent(
                isFirstLaunch = isFirst,
                model = instance.model,
                handleEvents = handleEvents
            )
        }

        MainState.Error -> {
            ErrorContent(
                onRefresh = { handleEvents(MainEvents.OnRefresh) }
            )
        }

        MainState.Loading -> {
            LoadingContent()
        }
    }

}