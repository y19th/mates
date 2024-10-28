package com.sochato.mates.core.util.local

import kotlinx.coroutines.CoroutineExceptionHandler

private const val handlerTag = "CaughtCoroutineException"

object Handler {
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        message(handlerTag, "-------------CAUGHT-------------", LoggerLevel.Error)
        message(
            handlerTag,
            "catched: ${throwable.stackTraceToString()}", LoggerLevel.Error
        )
        message(handlerTag, "-------------END_CAUGHT-------------", LoggerLevel.Error)
    }
}
