package com.sochato.mates.home.game_detail.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.domain.use_cases.library.RequestAddGameToProfileLibraryUseCase
import com.sochato.mates.core.domain.use_cases.library.RequestDeleteGameFromProfileLibraryUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.local.debugMessage
import com.sochato.mates.core.util.local.findWrummyException
import com.sochato.mates.core.util.models.SnackState
import com.sochato.mates.home.game_detail.domain.events.DetailGameEvents
import com.sochato.mates.home.game_detail.domain.models.LibraryConfig
import com.sochato.mates.home.game_detail.domain.models.toLibraryItem
import com.sochato.mates.home.game_detail.domain.state.DetailGameState
import com.sochato.mates.home.root.HomeNavigator

internal class DetailGameComponent(
    componentContext: ComponentContext,
    libraryItem: LibraryConfig,
    isAlreadyAdded: Boolean,
    private val navigator: HomeNavigator,
    private val requestAddGameToProfileLibrary: RequestAddGameToProfileLibraryUseCase,
    private val requestDeleteGameFromProfileLibrary: RequestDeleteGameFromProfileLibraryUseCase
) : ScreenComponent<DetailGameState, DetailGameEvents>(
    initialState = DetailGameState(
        item = libraryItem.toLibraryItem(),
        isAlreadyAdded = isAlreadyAdded
    ),
    componentContext = componentContext
) {
    override fun handleEvent(event: DetailGameEvents) {
        when (event) {
            DetailGameEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            DetailGameEvents.OnAddGameInProfileLibrary -> {
                launchIO {
                    requestAddGameToProfileLibrary(
                        gameId = state.value.item.id
                    ).onSuccess {
                        snackEffect(SnackState.success("success"))
                        navigate { navigator.pop() }
                    }.onFailure {
                        snackEffect(SnackState.failure(it.findWrummyException().message))
                        debugMessage(it.stackTraceToString())
                    }
                }
            }

            DetailGameEvents.OnDeleteGameFromProfileLibrary -> {
                launchIO {
                    requestDeleteGameFromProfileLibrary(
                        gameId = state.value.item.id
                    ).onSuccess {
                        snackEffect(SnackState.success(it))
                        navigate { navigator.pop() }
                    }.onFailure {
                        snackEffect(SnackState.failure(it.findWrummyException().message))
                        debugMessage(it.stackTraceToString())
                    }
                }
            }
        }
    }
}