package com.sochato.mates.home.main.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.domain.use_cases.profile.RequestProfileUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.local.MatesSettings
import com.sochato.mates.core.util.local.debugMessage
import com.sochato.mates.home.main.domain.events.MainEvents
import com.sochato.mates.home.main.domain.state.MainState
import com.sochato.mates.home.root.HomeNavigator
import com.sochato.mates.home.root.ui.HomeComponent
import com.sochato.mates.profile.profile.domain.model.ProfileConfig
import kotlinx.coroutines.withTimeout
import kotlin.time.Duration.Companion.seconds

internal class MainComponent(
    componentContext: ComponentContext,
    private val navigator: HomeNavigator,
    private val requestProfile: RequestProfileUseCase
) : ScreenComponent<MainState, MainEvents>(
    initialState = MainState.Loading,
    componentContext = componentContext
) {
    init {
        refresh()
    }

    override fun handleEvent(event: MainEvents) {
        when (event) {
            MainEvents.OnFirstLaunch -> {
                MatesSettings.firstHomeLaunch = false
            }

            MainEvents.OnRefresh -> {
                refresh()
            }

            is MainEvents.OnSearchChange -> {
                //update { it.copy(searchRequest = event.newValue) }
                // TODO navigate into search destination
            }

            MainEvents.OnNavigateToProfile -> {
                val instance = state.value
                if (instance is MainState.Data)
                    navigate {
                        navigator.handleConfiguration(
                            HomeComponent.Configuration.ProfileConfiguration(
                                config = ProfileConfig(instance.model)
                            )
                        )
                    }
            }
        }
    }

    private fun refresh() {
        update { MainState.Loading }
        launchIO {
            withTimeout(6.seconds) {
                requestProfile()
                    .onSuccess { model ->
                        update { MainState.Data(model = model) }
                    }.onFailure {
                        update { MainState.Error }
                        debugMessage(it.stackTraceToString())
                    }
            }
        }
    }
}