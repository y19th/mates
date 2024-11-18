package com.sochato.mates.core.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FriendResponse(
    val uid: String,
    val email: String,
    val nickname: String,
    @SerialName("mates_points") val matesPoints: Int,
    @SerialName("profile_picture") val profilePicture: String?
)