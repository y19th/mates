package com.sochato.mates.home.main.domain.state

import com.sochato.mates.core.util.base_components.BaseState

internal sealed class MainState: BaseState {

    data class Data(
        val searchRequest: String = ""
    ) : MainState()

    data object Loading: MainState()

    data object Error: MainState()
}
