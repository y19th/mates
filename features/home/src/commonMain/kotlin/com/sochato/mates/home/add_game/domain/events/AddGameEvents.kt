package com.sochato.mates.home.add_game.domain.events

import com.sochato.mates.core.domain.models.LibraryItem
import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface AddGameEvents: BaseEvents {

    data object OnNavigateBack: AddGameEvents

    data class OnNavigateToDetail(val item: LibraryItem): AddGameEvents

    data class OnSearchChanged(val newValue: String): AddGameEvents
}