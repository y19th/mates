package com.sochato.mates.core.domain.models

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class WrummyDispatchers {
    val io = Dispatchers.IO
    val default = Dispatchers.Default
    val main = Dispatchers.Main
}