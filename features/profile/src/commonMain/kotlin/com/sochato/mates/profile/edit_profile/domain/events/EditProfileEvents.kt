package com.sochato.mates.profile.edit_profile.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface EditProfileEvents: BaseEvents {

    data object OnNavigateBack: EditProfileEvents

    data class OnNicknameChange(val newValue: String): EditProfileEvents

    data class OnStatusChange(val newValue: String): EditProfileEvents

    data object OnValidate: EditProfileEvents
}