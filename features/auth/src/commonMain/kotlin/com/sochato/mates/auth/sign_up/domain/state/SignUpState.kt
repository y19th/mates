package com.sochato.mates.auth.sign_up.domain.state

import com.sochato.mates.core.util.base_components.BaseState

data class SignUpState(
    val email: String = "",
    val password: String = "",
    val repeatPassword: String = "",

    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
    val isPasswordRepeatError: Boolean = false,

    val isLoading: Boolean = false
): BaseState
