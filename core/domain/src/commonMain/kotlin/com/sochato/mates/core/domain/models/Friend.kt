package com.sochato.mates.core.domain.models

data class Friend(
    val uid: String,
    val email: String,
    val nickname: String,
    val matesPoints: Int,
    val profilePicture: String?
)
