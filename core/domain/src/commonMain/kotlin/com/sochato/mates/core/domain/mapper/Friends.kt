package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.data.model.response.FriendshipResponse
import com.sochato.mates.core.domain.models.Friendship
import com.sochato.mates.core.domain.models.FriendshipStatus
import kotlinx.collections.immutable.toImmutableList

fun List<FriendshipResponse>.toImmutableListOfFriendships() =
    map { it.toFriendship() }.toImmutableList()

fun FriendshipResponse.toFriendship() = Friendship(
    id = id,
    sender = sender,
    receiver = receiver,
    status = FriendshipStatus.find(status)
)