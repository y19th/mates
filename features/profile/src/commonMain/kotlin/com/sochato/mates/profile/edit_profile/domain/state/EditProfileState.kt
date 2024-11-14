package com.sochato.mates.profile.edit_profile.domain.state

import com.sochato.mates.core.util.base_components.BaseState
import com.sochato.mates.profile.profile.domain.model.ProfileConfig

internal data class EditProfileState(
    val profileIcon: String? = null,
    val nickname: String = "",
    val profileDescription: String = "",

    val isNicknameError: Boolean = false
): BaseState {
    constructor(config: ProfileConfig): this(
        profileIcon = config.pictureUrl,
        nickname = config.nickname,
        profileDescription = config.profileDescription
    )
}
