package com.sochato.mates.auth.forgot_password.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.auth.forgot_password.domain.events.ForgotPasswordEvents
import com.sochato.mates.auth.forgot_password.domain.state.ForgotPasswordState
import com.sochato.mates.auth.root.AuthNavigator
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.extension.isNotMatchEmailPattern

internal class ForgotPasswordComponent(
    componentContext: ComponentContext,
    private val navigator: AuthNavigator
) : ScreenComponent<ForgotPasswordState, ForgotPasswordEvents>(
    initialState = ForgotPasswordState(),
    componentContext = componentContext
) {
    override fun handleEvent(event: ForgotPasswordEvents) {
        when (event) {
            is ForgotPasswordEvents.OnEmailChanged -> {
                update {
                    it.copy(
                        email = event.newValue,
                        isEmailError = false
                    )
                }
            }

            ForgotPasswordEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            ForgotPasswordEvents.OnProceed -> {
                if (isValid()) {}
            }
        }
    }

    private fun isValid(): Boolean {
        return if (state.value.email.isNotMatchEmailPattern() || state.value.isEmailError) {
            update { it.copy(isEmailError = true) }
            false
        } else {
            true
        }
    }
}