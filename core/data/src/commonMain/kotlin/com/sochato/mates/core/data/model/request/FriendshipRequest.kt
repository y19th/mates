package com.sochato.mates.core.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class FriendshipRequest(val email: String)