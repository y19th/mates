package com.sochato.mates.core.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val refresh: String,
    val access: String
)
