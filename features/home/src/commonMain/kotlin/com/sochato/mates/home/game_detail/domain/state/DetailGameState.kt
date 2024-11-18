package com.sochato.mates.home.game_detail.domain.state

import com.sochato.mates.core.domain.models.LibraryItem
import com.sochato.mates.core.util.base_components.BaseState

internal data class DetailGameState(
    val item: LibraryItem,
    val isAlreadyAdded: Boolean = false
): BaseState
