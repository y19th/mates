package com.sochato.mates.core.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PatchProfilePhotoResponse(
    @SerialName("profile_picture")
    val profilePicture: String = ""
)
