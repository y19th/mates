package com.sochato.mates.core.util.models

sealed interface Transition {

    data object Authorized: Transition

    data object None: Transition

    companion object {
        fun find(value: Int) = when(value) {
            1 -> Authorized
            else -> None
        }
    }

    fun value() = when(this) {
        Authorized -> 1
        None -> 0
    }
}