package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.model.response.MateResponse
import com.sochato.mates.core.domain.models.FriendshipStatus
import com.sochato.mates.core.domain.models.Mate

internal fun MateResponse.toMateModel(status: FriendshipStatus) = Mate(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    status = status,
    profilePicture = "${MatesApi.WithoutApi}$profilePicture".takeIf { profilePicture != null }
)