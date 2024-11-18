package com.sochato.mates.profile.friends.domain

import com.sochato.mates.core.domain.models.Friend
import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.util.base_components.BaseState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class FriendsState(
    val friendsList: ImmutableList<Friend> = persistentListOf(),
    val profileModel: ProfileModel = ProfileModel()
) : BaseState
