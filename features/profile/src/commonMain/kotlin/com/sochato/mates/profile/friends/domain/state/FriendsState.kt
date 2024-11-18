package com.sochato.mates.profile.friends.domain.state

import com.sochato.mates.core.domain.models.Mate
import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.util.base_components.BaseState
import com.sochato.mates.profile.friends.domain.models.InternalMate
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class FriendsState(
    val profileModel: ProfileModel = ProfileModel(),
    val friendsList: ImmutableList<InternalMate> = persistentListOf(),

    val allUsers: ImmutableList<Mate> = persistentListOf(),
    val filteredUsers: List<InternalMate> = persistentListOf(),

    val requestedMates: List<String> = persistentListOf(),

    val search: String = ""
) : BaseState
