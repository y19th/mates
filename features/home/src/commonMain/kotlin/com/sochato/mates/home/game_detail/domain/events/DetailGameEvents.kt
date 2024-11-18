package com.sochato.mates.home.game_detail.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface DetailGameEvents: BaseEvents {

    data object OnNavigateBack: DetailGameEvents

    data object OnAddGameInProfileLibrary: DetailGameEvents

    data object OnDeleteGameFromProfileLibrary: DetailGameEvents
}