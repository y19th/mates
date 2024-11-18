package com.sochato.mates.profile.profile.domain.model

import com.sochato.mates.profile.friends.domain.models.InternalMate
import kotlinx.serialization.Serializable

@Serializable
data class ExternalProfileConfig(
    val uid: String,
    val email: String,
    val nickname: String,
    val matesPoints: Int,
    val profilePicture: String?,
    val isFriend: Boolean
)

data class ExternalProfile(
    val uid: String,
    val email: String,
    val nickname: String,
    val matesPoints: Int,
    val profilePicture: String?,
    val isFriend: Boolean
)

internal fun InternalMate.toExternalConfig() = ExternalProfileConfig(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    profilePicture = profilePicture,
    isFriend = isFriend
)

internal fun ExternalProfileConfig.toExternalProfile() = ExternalProfile(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    profilePicture = profilePicture,
    isFriend = isFriend
)