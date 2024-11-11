package com.sochato.mates.auth.login.domain.state

import com.sochato.mates.core.util.base_components.BaseState

internal data class LoginState(
    val email: String = "aaa@aaa.ru",
    val password: String = "123456",

    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,

    val isLoading: Boolean = false
): BaseState
