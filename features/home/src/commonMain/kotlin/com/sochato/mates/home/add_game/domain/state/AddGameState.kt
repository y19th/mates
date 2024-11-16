package com.sochato.mates.home.add_game.domain.state

import com.sochato.mates.core.domain.models.LibraryItem
import com.sochato.mates.core.util.base_components.BaseState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class AddGameState(
    val library: ImmutableList<LibraryItem> = persistentListOf(),
    val search: String = ""
): BaseState
