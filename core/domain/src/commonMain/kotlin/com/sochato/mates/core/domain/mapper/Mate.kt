package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.model.response.MateResponse
import com.sochato.mates.core.domain.models.Mate
import kotlinx.collections.immutable.toImmutableList

internal fun List<MateResponse>.toImmutableMateList() = map { it.toMateModel() }.toImmutableList()

internal fun MateResponse.toMateModel() = Mate(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    profilePicture = "${MatesApi.WithoutApi}$profilePicture".takeIf { profilePicture != null }
)