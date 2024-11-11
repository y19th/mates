package com.sochato.mates.profile.profile.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.domain.use_cases.LogoutUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.profile.profile.domain.events.ProfileEvents
import com.sochato.mates.profile.profile.domain.model.ProfileConfig
import com.sochato.mates.profile.profile.domain.model.toProfileModel
import com.sochato.mates.profile.profile.domain.state.ProfileState
import com.sochato.mates.profile.root.RootProfileNavigator

internal class ProfileComponent(
    componentContext: ComponentContext,
    config: ProfileConfig,
    private val navigator: RootProfileNavigator,
    private val logout: LogoutUseCase
) : ScreenComponent<ProfileState, ProfileEvents>(
    initialState = ProfileState(config.toProfileModel()),
    componentContext = componentContext
) {
    override fun handleEvent(event: ProfileEvents) {
        when (event) {
            ProfileEvents.OnNavigateBack -> {
                navigate { navigator.navigateHome() }
            }

            ProfileEvents.OnLogout -> {
                launchIO {
                    logout()
                }.invokeOnCompletion {
                    navigate { navigator.logout() }
                }
            }
        }
    }
}