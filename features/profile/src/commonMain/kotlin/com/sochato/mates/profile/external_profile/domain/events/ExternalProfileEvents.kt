package com.sochato.mates.profile.external_profile.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface ExternalProfileEvents: BaseEvents {

    data object OnNavigateBack: ExternalProfileEvents

    data object OnRefresh: ExternalProfileEvents

    data object OnOpenSheet: ExternalProfileEvents

    data object OnNavigateToMates: ExternalProfileEvents
}