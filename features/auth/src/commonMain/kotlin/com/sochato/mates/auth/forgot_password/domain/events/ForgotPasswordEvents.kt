package com.sochato.mates.auth.forgot_password.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface ForgotPasswordEvents: BaseEvents {

    data object OnNavigateBack: ForgotPasswordEvents

    data object OnProceed: ForgotPasswordEvents

    data class OnEmailChanged(val newValue: String): ForgotPasswordEvents
}