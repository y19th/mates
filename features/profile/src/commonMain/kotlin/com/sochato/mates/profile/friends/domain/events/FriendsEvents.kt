package com.sochato.mates.profile.friends.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface FriendsEvents: BaseEvents {

    data object OnNavigateBack: FriendsEvents

    data class OnSearchChanged(val newValue: String): FriendsEvents
}