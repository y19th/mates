package com.sochato.mates.core.util.models

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable
data class SnackState @OptIn(ExperimentalUuidApi::class) constructor(
    val message: String? = null,
    val status: SnackStatus = SnackStatus.Undefined,
    val id: String = Uuid.random().toHexString()
) {
    companion object {
        val empty = SnackState()

        fun failure(message: String) = SnackState(message, SnackStatus.Failure)

        fun success(message: String) = SnackState(message, SnackStatus.Success)
    }
}

@Serializable
sealed class SnackStatus(val value: Int) {

    @Serializable
    data object Success: SnackStatus(0)

    @Serializable
    data object Failure: SnackStatus(1)

    @Serializable
    data object Undefined: SnackStatus(2)
}
