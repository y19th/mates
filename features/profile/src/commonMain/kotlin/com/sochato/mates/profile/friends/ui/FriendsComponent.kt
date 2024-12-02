package com.sochato.mates.profile.friends.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.domain.models.isContainsRequestedMate
import com.sochato.mates.core.domain.use_cases.friends.AcceptFriendshipUseCase
import com.sochato.mates.core.domain.use_cases.friends.RequestAllUsersUseCase
import com.sochato.mates.core.domain.use_cases.friends.RequestFriendsUseCase
import com.sochato.mates.core.domain.use_cases.friends.RequestFriendshipUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.base_components.snackState
import com.sochato.mates.core.util.models.SnackState
import com.sochato.mates.profile.friends.domain.events.FriendsEvents
import com.sochato.mates.profile.friends.domain.models.mapToMate
import com.sochato.mates.profile.friends.domain.state.FriendsState
import com.sochato.mates.profile.profile.domain.model.ProfileConfig
import com.sochato.mates.profile.profile.domain.model.toExternalConfig
import com.sochato.mates.profile.profile.domain.model.toProfileModel
import com.sochato.mates.profile.root.RootProfileNavigator
import com.sochato.mates.profile.root.ui.RootProfileComponent
import kotlinx.collections.immutable.toImmutableList

internal class FriendsComponent(
    componentContext: ComponentContext,
    config: ProfileConfig,
    private val navigator: RootProfileNavigator,
    private val requestAllUsers: RequestAllUsersUseCase,
    private val requestFriendship: RequestFriendshipUseCase,
    private val requestFriends: RequestFriendsUseCase,
    private val acceptFriendship: AcceptFriendshipUseCase
) : ScreenComponent<FriendsState, FriendsEvents>(
    componentContext = componentContext,
    initialState = FriendsState(profileModel = config.toProfileModel())
) {
    init {
        launchIO {
            requestAllUsers()
                .onSuccess { users -> update { it.copy(allUsers = users) } }
                .onFailure { snackEffect(SnackState.failure("Не удалось получить список пользователей")) }

            requestFriends()
                .onSuccess { friendship ->
                    val friends = state.value.allUsers
                        .asSequence()
                        .filter { mate ->
                            friendship.any { friendship ->
                                friendship.receiver == mate.email || friendship.sender == mate.email
                            }
                        }
                        .map {
                            it.mapToMate(
                                isFriend = true,
                                isRequested = friendship.isContainsRequestedMate(it)
                            )
                        }
                        .filter { internalMate ->
                            config.email != internalMate.email
                        }
                        .toImmutableList()

                    update { it.copy(friendsList = friends) }
                }
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
                                    isFriend = state.value.friendsList.any { iMate -> iMate.uid == it.uid },
                                    isRequested = state.value.requestedMates.contains(it.uid)
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
                            config = event.internalMate.toExternalConfig()
                        )
                    )
                }
            }

            is FriendsEvents.OnRequestFriendship -> {
                launchIO {
                    requestFriendship(event.internalMate.email)
                        .onSuccess { result ->
                            snackEffect(SnackState.success(result))
                            update {
                                it.copy(
                                    requestedMates = state.value.requestedMates.plus(event.internalMate.uid)
                                )
                            }
                        }.onFailure {
                            snackEffect(it.snackState())
                        }
                }
            }

            is FriendsEvents.OnAcceptFriendship -> {
                launchIO {
                    requestFriends()
                        .onSuccess { friendship ->
                            friendship.first {
                                it.sender == event.internalMate.email && it.receiver == state.value.profileModel.email
                            }.let {
                                acceptFriendship(it.id)
                                    .onSuccess {
                                        snackEffect(SnackState.success(it))
                                    }.onFailure { throwable ->
                                        snackEffect(throwable.snackState())
                                    }
                            }
                        }.onFailure {
                            snackEffect(it.snackState())
                        }
                }
            }
        }
    }
}