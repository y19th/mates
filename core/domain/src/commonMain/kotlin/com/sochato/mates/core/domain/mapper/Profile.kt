package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.data.model.response.ProfileResponse
import com.sochato.mates.core.domain.models.ProfileModel

fun ProfileResponse.toProfileModel() = ProfileModel(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    registrationDate = registrationDate,
    profileDescription = profileDescription ?: "",
    status = status,
    pictureUrl = pictureUrl
)