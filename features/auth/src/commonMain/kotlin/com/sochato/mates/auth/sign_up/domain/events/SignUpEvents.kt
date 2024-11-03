package com.sochato.mates.auth.sign_up.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface SignUpEvents : BaseEvents {

    data class OnEmailChange(val newValue: String) : SignUpEvents

    data class OnPasswordChange(val newValue: String) : SignUpEvents

    data class OnRepeatPasswordChange(val newValue: String) : SignUpEvents

    data class OnNicknameChange(val newValue: String) : SignUpEvents

    data object OnNavigateBack : SignUpEvents

    data object OnSignUp : SignUpEvents
}