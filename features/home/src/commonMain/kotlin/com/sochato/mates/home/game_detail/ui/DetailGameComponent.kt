package com.sochato.mates.home.game_detail.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.home.game_detail.domain.events.DetailGameEvents
import com.sochato.mates.home.game_detail.domain.models.LibraryConfig
import com.sochato.mates.home.game_detail.domain.models.toLibraryItem
import com.sochato.mates.home.game_detail.domain.state.DetailGameState
import com.sochato.mates.home.root.HomeNavigator

internal class DetailGameComponent(
    componentContext: ComponentContext,
    libraryItem: LibraryConfig,
    private val navigator: HomeNavigator
) : ScreenComponent<DetailGameState, DetailGameEvents>(
    initialState = DetailGameState(libraryItem.toLibraryItem()),
    componentContext = componentContext
) {
    override fun handleEvent(event: DetailGameEvents) {
        when (event) {
            DetailGameEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            DetailGameEvents.OnAddGameInProfileLibrary -> {

            }
        }
    }
}