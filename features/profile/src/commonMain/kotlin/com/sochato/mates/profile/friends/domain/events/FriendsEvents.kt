package com.sochato.mates.profile.friends.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents
import com.sochato.mates.profile.friends.domain.models.InternalMate

internal sealed interface FriendsEvents: BaseEvents {

    data object OnNavigateBack: FriendsEvents

    data class OnSearchChanged(val newValue: String): FriendsEvents

    data class OnNavigateToMateProfile(val internalMate: InternalMate): FriendsEvents

    data class OnRequestFriendship(val internalMate: InternalMate): FriendsEvents
}