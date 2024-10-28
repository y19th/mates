package com.sochato.mates.auth.login.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface LoginEvents: BaseEvents {

    data class OnEmailChanged(val newValue: String): LoginEvents

    data class OnPasswordChanged(val newValue: String): LoginEvents

    data object OnLogin: LoginEvents

    data object OnSignUp: LoginEvents

    data object OnForgotPassword: LoginEvents
}