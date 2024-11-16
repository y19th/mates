package com.sochato.mates.home.main.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.domain.use_cases.library.RequestProfileLibraryUseCase
import com.sochato.mates.core.domain.use_cases.news.RequestNewsUseCase
import com.sochato.mates.core.domain.use_cases.profile.RequestProfileUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.local.MatesSettings
import com.sochato.mates.core.util.local.debugMessage
import com.sochato.mates.home.main.domain.events.MainEvents
import com.sochato.mates.home.main.domain.model.MainNews
import com.sochato.mates.home.main.domain.model.toMainNews
import com.sochato.mates.home.main.domain.state.MainState
import com.sochato.mates.home.root.HomeNavigator
import com.sochato.mates.home.root.ui.HomeComponent
import com.sochato.mates.profile.profile.domain.model.ProfileConfig
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.coroutines.withTimeout
import kotlin.time.Duration.Companion.seconds

internal class MainComponent(
    componentContext: ComponentContext,
    private val navigator: HomeNavigator,
    private val requestProfile: RequestProfileUseCase,
    private val requestNews: RequestNewsUseCase,
    private val requestProfileLibrary: RequestProfileLibraryUseCase
) : ScreenComponent<MainState, MainEvents>(
    initialState = MainState(),
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

            MainEvents.OnNavigateToAddGame -> {
                navigate {
                    navigator.handleConfiguration(HomeComponent.Configuration.AddGameConfiguration)
                }
            }

            is MainEvents.OnSearchChange -> {
                //update { it.copy(searchRequest = event.newValue) }
                // TODO navigate into search destination
            }

            MainEvents.OnNavigateToProfile -> {
                val instance = state.value
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
        update { it.copy(isLoading = true) }
        launchIO {
            launchIO {
                withTimeout(6.seconds) {
                    requestProfile()
                        .onSuccess { model ->
                            update { it.copy(model = model, isError = false) }
                        }.onFailure { throwable ->
                            update { it.copy(isError = true) }
                            debugMessage(throwable.stackTraceToString())
                        }
                }
            }
            launchIO {
                requestProfileLibrary()
                    .onSuccess { library ->
                        update { it.copy(library = library) }
                    }.onFailure {
                        update { it.copy(isError = true) }
                    }
            }
            launchIO {
                requestNews()
                    .onSuccess { news ->
                        val hashMap = hashMapOf<String, MutableList<MainNews>>()

                        news.forEach { item ->
                            hashMap.getOrPut(
                                key = item.game ?: "",
                                defaultValue = { mutableListOf() }
                            ).add(item.toMainNews())
                        }

                        hashMap
                            .mapValues { it.value.toImmutableList() }
                            .toImmutableMap()
                            .let { immutableMap ->
                                update { it.copy(news = immutableMap, isError = false) }
                            }
                    }.onFailure {
                        update { it.copy(isError = true) }
                    }
            }
        }.invokeOnCompletion {
            update { it.copy(isLoading = false) }
        }
    }
}