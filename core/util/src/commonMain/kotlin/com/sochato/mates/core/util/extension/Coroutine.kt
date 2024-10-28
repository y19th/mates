package com.sochato.mates.core.util.extension

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlin.time.Duration

suspend fun Job.cancelOnDelay(delay: Duration) {
    delay(delay)
    this.cancel()
}