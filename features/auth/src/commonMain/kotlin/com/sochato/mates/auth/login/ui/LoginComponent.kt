package com.sochato.mates.auth.login.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.auth.login.domain.events.LoginEvents
import com.sochato.mates.auth.login.domain.state.LoginState
import com.sochato.mates.auth.root.AuthNavigator
import com.sochato.mates.auth.root.ui.AuthComponent
import com.sochato.mates.core.domain.use_cases.login.RequestLoginUseCase
import com.sochato.mates.core.domain.use_cases.transition.UpdateTransitionUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.extension.isNotMatchEmailPattern
import com.sochato.mates.core.util.local.findWrummyException
import com.sochato.mates.core.util.models.SnackState
import com.sochato.mates.core.util.models.Transition.Authorized

internal class LoginComponent(
    componentContext: ComponentContext,
    private val navigator: AuthNavigator,
    private val updateTransition: UpdateTransitionUseCase,
    private val requestLogin: RequestLoginUseCase
) : ScreenComponent<LoginState, LoginEvents>(
    initialState = LoginState(),
    componentContext = componentContext
) {
    override fun handleEvent(event: LoginEvents) {
        when (event) {
            is LoginEvents.OnEmailChanged -> {
                update {
                    it.copy(
                        email = event.newValue,
                        isEmailError = false
                    )
                }
            }

            is LoginEvents.OnPasswordChanged -> {
                update {
                    it.copy(
                        password = event.newValue,
                        isPasswordError = false
                    )
                }
            }

            LoginEvents.OnLogin -> {
                if (isValid()) {
                    launchIO {
                        requestLogin(
                            email = state.value.email,
                            password = state.value.password
                        ).onSuccess {
                            snackEffect(SnackState.success("success"))
                            launchIO {
                                updateTransition(Authorized)
                            }.invokeOnCompletion {
                                navigate {
                                    navigator.navigateHome()
                                }
                            }
                        }.onFailure {
                            snackEffect(SnackState.failure(it.findWrummyException().message))
                        }
                    }
                }
            }

            LoginEvents.OnSignUp -> {
                navigate {
                    navigator.handleConfiguration(
                        AuthComponent.Configuration.SignUpConfiguration
                    )
                }
            }

            LoginEvents.OnForgotPassword -> {
                navigate {
                    navigator.handleConfiguration(
                        AuthComponent.Configuration.ForgotPasswordConfiguration
                    )
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
        }

        return valid
    }

    private fun String.isNotPasswordMatch(): Boolean {
        return this.isEmpty() || this.length < 6
    }
}