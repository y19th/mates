package com.sochato.mates.core.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AcceptFriendshipRequest(
    @SerialName("friendship_id") val friendshipId: Int
)
