package com.sochato.mates.profile.profile.domain.model

import com.sochato.mates.core.domain.models.ProfileModel
import kotlinx.serialization.Serializable

@Serializable
data class ProfileConfig(
    val uid: String = "",
    val email: String = "",
    val nickname: String = "",
    val matesPoints: Int = 0,
    val registrationDate: String = "",
    val profileDescription: String = "",
    val status: String = "",
    val pictureUrl: String? = null
) {
    constructor(
        model: ProfileModel
    ): this(
        uid = model.uid,
        email = model.email,
        nickname = model.nickname,
        matesPoints = model.matesPoints,
        registrationDate = model.registrationDate,
        profileDescription = model.profileDescription,
        status = model.status,
        pictureUrl = model.pictureUrl
    )
}

internal fun ProfileConfig.toProfileModel() = ProfileModel(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    registrationDate = registrationDate,
    profileDescription = profileDescription,
    status = status,
    pictureUrl = pictureUrl
)