package com.sochato.mates.core.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshRequest(@SerialName("refresh") val refreshToken: String)
