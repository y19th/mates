package com.sochato.mates.home.main.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.local.MatesSettings
import com.sochato.mates.home.main.domain.events.MainEvents
import com.sochato.mates.home.main.domain.state.MainState
import com.sochato.mates.home.root.HomeNavigator

internal class MainComponent(
    componentContext: ComponentContext,
    private val navigator: HomeNavigator
) : ScreenComponent<MainState, MainEvents>(
    initialState = MainState.Loading,
    componentContext = componentContext
) {
    init {
        update { MainState.Data() }
    }

    override fun handleEvent(event: MainEvents) {
        when (event) {
            MainEvents.OnFirstLaunch -> {
                MatesSettings.firstHomeLaunch = false
            }

            MainEvents.OnRefresh -> {
            }

            is MainEvents.OnSearchChange -> {
                //update { it.copy(searchRequest = event.newValue) }
                // TODO navigate into search destination
            }

            MainEvents.OnNavigateToProfile -> {
                navigate {

                }
            }
        }
    }
}