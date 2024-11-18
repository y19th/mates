package com.sochato.mates.profile.friends.domain.state

import com.sochato.mates.core.domain.models.Friend
import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.util.base_components.BaseState
import com.sochato.mates.profile.friends.domain.models.Mate
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class FriendsState(
    val friendsList: ImmutableList<Friend> = persistentListOf(),
    val profileModel: ProfileModel = ProfileModel(),

    val allUsers: ImmutableList<Friend> = persistentListOf(),
    val filteredUsers: List<Mate> = persistentListOf(),

    val search: String = ""
) : BaseState
