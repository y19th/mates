package com.sochato.mates.profile.profile.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.domain.use_cases.LogoutUseCase
import com.sochato.mates.core.domain.use_cases.user.ReceiveUserUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.profile.profile.domain.events.ProfileEvents
import com.sochato.mates.profile.profile.domain.model.ProfileConfig
import com.sochato.mates.profile.profile.domain.state.ProfileState
import com.sochato.mates.profile.root.RootProfileNavigator
import com.sochato.mates.profile.root.ui.RootProfileComponent

internal class ProfileComponent(
    componentContext: ComponentContext,
    private val navigator: RootProfileNavigator,
    private val logout: LogoutUseCase,
    private val receiveUser: ReceiveUserUseCase
) : ScreenComponent<ProfileState, ProfileEvents>(
    initialState = ProfileState(),
    componentContext = componentContext
) {
    override fun handleEvent(event: ProfileEvents) {
        when (event) {
            ProfileEvents.OnNavigateBack -> {
                navigate { navigator.navigateHome() }
            }

            ProfileEvents.OnNavigateToEdit -> {
                navigate {
                    navigator.handleConfiguration(
                        RootProfileComponent.Configuration.EditProfileConfiguration(
                            config = ProfileConfig(state.value.model)
                        )
                    )
                }
            }

            ProfileEvents.OnLogout -> {
                launchIO {
                    logout()
                }.invokeOnCompletion {
                    navigate { navigator.logout() }
                }
            }

            ProfileEvents.OnRefresh -> {
                updateUser()
            }

            ProfileEvents.OnNavigateToMates -> {
                navigate {
                    navigator.handleConfiguration(
                        RootProfileComponent.Configuration.MatesConfiguration(
                            config = ProfileConfig(state.value.model)
                        )
                    )
                }
            }
        }
    }

    private fun updateUser() {
        launchIO {
            update { it.copy(model = receiveUser()) }
        }
    }
}