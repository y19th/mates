package com.sochato.mates.core.domain.models

data class Mate(
    val uid: String,
    val email: String,
    val nickname: String,
    val matesPoints: Int,
    val profilePicture: String?,
    val status: FriendshipStatus = FriendshipStatus.StandardUnknown
)
