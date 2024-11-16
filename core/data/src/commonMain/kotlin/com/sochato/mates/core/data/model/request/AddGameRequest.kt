package com.sochato.mates.core.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddGameRequest(@SerialName("game_id") val gameId: Int)
