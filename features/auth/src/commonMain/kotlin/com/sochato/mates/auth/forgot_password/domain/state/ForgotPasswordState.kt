package com.sochato.mates.auth.forgot_password.domain.state

import com.sochato.mates.core.util.base_components.BaseState

internal data class ForgotPasswordState(
    val email: String = "",
    val isEmailError: Boolean = false,
    val isLoading: Boolean = false
): BaseState
