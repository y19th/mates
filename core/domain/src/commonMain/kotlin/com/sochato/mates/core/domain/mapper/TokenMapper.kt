package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.data.model.response.LoginResponse
import com.sochato.mates.core.local.entities.TokenEntity

fun LoginResponse.toTokenEntity() = TokenEntity(
    access = access,
    refresh = refresh
)