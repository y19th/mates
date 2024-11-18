package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.model.response.FriendResponse
import com.sochato.mates.core.domain.models.Friend
import kotlinx.collections.immutable.toImmutableList

internal fun List<FriendResponse>.toImmutableFriendsList() = map { it.toFriendModel() }.toImmutableList()

internal fun FriendResponse.toFriendModel() = Friend(
    uid = uid,
    email = email,
    nickname = nickname,
    matesPoints = matesPoints,
    profilePicture = "${MatesApi.WithoutApi}$profilePicture".takeIf { profilePicture != null }
)