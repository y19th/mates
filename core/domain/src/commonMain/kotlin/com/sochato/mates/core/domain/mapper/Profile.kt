package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.model.response.ProfileResponse
import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.local.entities.UserEntity

fun ProfileResponse.toProfileModel() = ProfileModel(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    registrationDate = registrationDate,
    profileDescription = profileDescription ?: "",
    status = status,
    pictureUrl = "${MatesApi.WithoutApi}$pictureUrl".takeIf { pictureUrl != null }
)

fun ProfileModel.toProfileEntity() = UserEntity(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    registrationDate = registrationDate,
    profileDescription = profileDescription,
    status = status,
    pictureUrl = pictureUrl
)

fun UserEntity.toProfileModel() = ProfileModel(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    registrationDate = registrationDate,
    profileDescription = profileDescription,
    status = status,
    pictureUrl = pictureUrl
)