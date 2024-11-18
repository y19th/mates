package com.sochato.mates.profile.friends.domain.models

import com.sochato.mates.core.domain.models.Mate

internal data class InternalMate(
    val uid: String,
    val email: String,
    val nickname: String,
    val matesPoints: Int,
    val profilePicture: String?,
    val isFriend: Boolean = false,
    val isRequested: Boolean = false
)

internal fun Mate.mapToMate(isFriend: Boolean, isRequested: Boolean) = InternalMate(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    profilePicture = profilePicture,
    isFriend = isFriend,
    isRequested = isRequested
)