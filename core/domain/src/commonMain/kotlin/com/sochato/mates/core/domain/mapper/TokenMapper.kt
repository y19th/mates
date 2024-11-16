package com.sochato.mates.core.domain.mapper

import com.sochato.mates.core.local.entities.TokenEntity
import com.sochato.mates.core.util.models.Token

fun Token.toTokenEntity() = TokenEntity(
    access = access,
    refresh = refresh
)