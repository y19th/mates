package com.sochato.mates.core.data.model.request

import kotlinx.serialization.Serializable

@Serializable
internal sealed interface PatchProfileRequest {

    val nickname: String
    val profileDescription: String

    @Serializable
    class ProfileRequest(
        override val nickname: String,
        override val profileDescription: String
    ) : PatchProfileRequest

    @Serializable
    class ProfileRequestWithImage(
        override val nickname: String,
        override val profileDescription: String,
        val imageUrl: String
    ) : PatchProfileRequest
}