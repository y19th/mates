package com.sochato.mates.home.add_game.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.domain.use_cases.library.RequestLibraryUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.local.debugMessage
import com.sochato.mates.core.util.local.findWrummyException
import com.sochato.mates.core.util.models.SnackState
import com.sochato.mates.home.add_game.domain.events.AddGameEvents
import com.sochato.mates.home.add_game.domain.state.AddGameState
import com.sochato.mates.home.game_detail.domain.models.toLibraryConfig
import com.sochato.mates.home.root.HomeNavigator
import com.sochato.mates.home.root.ui.HomeComponent

internal class AddGameComponent(
    componentContext: ComponentContext,
    private val navigator: HomeNavigator,
    private val requestLibrary: RequestLibraryUseCase
) : ScreenComponent<AddGameState, AddGameEvents>(
    initialState = AddGameState(),
    componentContext = componentContext
) {
    init {
        launchIO {
            requestLibrary()
                .onSuccess { library -> update { it.copy(library = library) } }
                .onFailure {
                    snackEffect(SnackState.failure(it.findWrummyException().message))
                    debugMessage(it.stackTraceToString())
                }
        }
    }

    override fun handleEvent(event: AddGameEvents) {
        when (event) {
            AddGameEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            is AddGameEvents.OnSearchChanged -> {
                update { it.copy(search = event.newValue) }
            }

            is AddGameEvents.OnNavigateToDetail -> {
                navigate {
                    navigator.handleConfiguration(
                        HomeComponent.Configuration.DetailGameConfiguration(
                            item = event.item.toLibraryConfig()
                        )
                    )
                }
            }
        }
    }
}