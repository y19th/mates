package com.sochato.mates.core.domain.models

data class Friendship(
    val id: Int,
    val sender: String,
    val receiver: String,
    val status: FriendshipStatus
)

sealed interface FriendshipStatus {

    companion object {
        fun find(value: String): FriendshipStatus = when (value) {
            "pending" -> Pending
            else -> Unknown(value)
        }
    }

    data object Pending : FriendshipStatus

    data class Unknown(val value: String) : FriendshipStatus
}