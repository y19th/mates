package com.sochato.mates.profile.profile.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface ProfileEvents: BaseEvents {

    data object OnNavigateBack: ProfileEvents

    data object OnRefresh: ProfileEvents

    data object OnNavigateToEdit: ProfileEvents

    data object OnLogout: ProfileEvents
}