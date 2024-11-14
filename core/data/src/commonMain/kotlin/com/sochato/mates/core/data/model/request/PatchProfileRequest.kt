package com.sochato.mates.core.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PatchProfileRequest(
    @SerialName("nickname") val nickname: String,
    @SerialName("profile_description") val profileDescription: String
)
