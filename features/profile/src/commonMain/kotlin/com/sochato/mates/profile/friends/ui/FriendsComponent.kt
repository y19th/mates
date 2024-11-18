package com.sochato.mates.profile.friends.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.domain.use_cases.friends.RequestAllUsersUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.models.SnackState
import com.sochato.mates.profile.friends.domain.events.FriendsEvents
import com.sochato.mates.profile.friends.domain.models.mapToMate
import com.sochato.mates.profile.friends.domain.state.FriendsState
import com.sochato.mates.profile.profile.domain.model.ProfileConfig
import com.sochato.mates.profile.profile.domain.model.toExternalConfig
import com.sochato.mates.profile.profile.domain.model.toProfileModel
import com.sochato.mates.profile.root.RootProfileNavigator
import com.sochato.mates.profile.root.ui.RootProfileComponent

internal class FriendsComponent(
    componentContext: ComponentContext,
    config: ProfileConfig,
    private val navigator: RootProfileNavigator,
    private val requestAllUsers: RequestAllUsersUseCase
) : ScreenComponent<FriendsState, FriendsEvents>(
    componentContext = componentContext,
    initialState = FriendsState(profileModel = config.toProfileModel())
) {
    init {
        launchIO {
            requestAllUsers()
                .onSuccess { users -> update { it.copy(allUsers = users) } }
                .onFailure { snackEffect(SnackState.failure("Не удалось получить список пользователей")) }
        }
    }

    override fun handleEvent(event: FriendsEvents) {
        when (event) {
            FriendsEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            is FriendsEvents.OnSearchChanged -> {
                launchIO {
                    val filtered =
                        state.value.allUsers
                            .asSequence()
                            .filter {
                                it.nickname.contains(event.newValue, true)
                                        && it.uid != state.value.profileModel.uid
                            }.map {
                                it.mapToMate(
                                    isFriend = state.value.friendsList.contains(it)
                                )
                            }.toList()

                    update {
                        it.copy(
                            filteredUsers = filtered
                        )
                    }
                }
                update { it.copy(search = event.newValue) }
            }

            is FriendsEvents.OnNavigateToMateProfile -> {
                navigate {
                    navigator.handleConfiguration(
                        RootProfileComponent.Configuration.ExternalProfileConfiguration(
                            config = event.mate.toExternalConfig()
                        )
                    )
                }
            }
        }
    }
}