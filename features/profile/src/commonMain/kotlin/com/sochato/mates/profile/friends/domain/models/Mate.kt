package com.sochato.mates.profile.friends.domain.models

import com.sochato.mates.core.domain.models.Friend

internal data class Mate(
    val uid: String,
    val email: String,
    val nickname: String,
    val matesPoints: Int,
    val profilePicture: String?,
    val isFriend: Boolean = false
)

internal fun Friend.mapToMate(isFriend: Boolean) = Mate(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    profilePicture = profilePicture,
    isFriend = isFriend
)
