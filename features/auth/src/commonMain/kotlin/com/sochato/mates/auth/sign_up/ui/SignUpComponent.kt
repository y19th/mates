package com.sochato.mates.auth.sign_up.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.auth.root.AuthNavigator
import com.sochato.mates.auth.sign_up.domain.events.SignUpEvents
import com.sochato.mates.auth.sign_up.domain.state.SignUpState
import com.sochato.mates.core.domain.use_cases.transition.UpdateTransitionUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.extension.isNotMatchEmailPattern

internal class SignUpComponent(
    componentContext: ComponentContext,
    private val navigator: AuthNavigator,
    private val updateTransition: UpdateTransitionUseCase
) : ScreenComponent<SignUpState, SignUpEvents>(
    initialState = SignUpState(),
    componentContext = componentContext
) {
    override fun handleEvent(event: SignUpEvents) {
        when (event) {
            SignUpEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            is SignUpEvents.OnEmailChange -> {
                update {
                    it.copy(
                        email = event.newValue,
                        isEmailError = false
                    )
                }
            }

            is SignUpEvents.OnPasswordChange -> {
                update {
                    it.copy(
                        password = event.newValue,
                        isPasswordError = false
                    )
                }
            }

            is SignUpEvents.OnRepeatPasswordChange -> {
                update {
                    it.copy(
                        repeatPassword = event.newValue,
                        isPasswordRepeatError = false
                    )
                }
            }

            SignUpEvents.OnSignUp -> {
                if (isValid()) {
                }
            }
        }
    }

    private fun isValid(): Boolean {
        var valid = true

        with(state.value) {
            if (email.isNotMatchEmailPattern() || isEmailError) {
                update { it.copy(isEmailError = true) }
                valid = false
            }
            if (password.isNotPasswordMatch() || isPasswordError) {
                update { it.copy(isPasswordError = true) }
                valid = false
            }
            if (repeatPassword != password || isPasswordRepeatError) {
                update { it.copy(isPasswordRepeatError = true) }
                valid = false
            }
        }

        return valid
    }

    private fun String.isNotPasswordMatch(): Boolean {
        return this.isEmpty() || this.length < 6
    }

}