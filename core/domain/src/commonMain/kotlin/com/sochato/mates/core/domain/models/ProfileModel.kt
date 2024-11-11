package com.sochato.mates.core.domain.models

data class ProfileModel(
    val uid: String = "",
    val email: String = "",
    val nickname: String = "",
    val matesPoints: Int = 0,
    val registrationDate: String = "",
    val profileDescription: String = "",
    val status: String = "",
    val pictureUrl: String? = null
)

