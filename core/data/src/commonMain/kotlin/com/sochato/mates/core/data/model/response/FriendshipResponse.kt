package com.sochato.mates.core.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class FriendshipResponse(
    val id: Int,
    val sender: String,
    val receiver: String,
    val status: String
)
