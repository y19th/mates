package com.sochato.mates.core.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    @SerialName("ui") val uid: String,
    val email: String,
    val nickname: String,
    @SerialName("mates_points") val matesPoints: Int,
    @SerialName("registration_date") val registrationDate: String,
    @SerialName("profile_description") val profileDescription: String?,
    @SerialName("status") val status: String,
    @SerialName("profile_picture") val pictureUrl: String?
)
