package com.sochato.mates.core.domain.models

data class Friendship(
    val id: Int,
    val sender: String,
    val receiver: String,
    val status: FriendshipStatus
)

fun List<Friendship>.isContainsRequestedMate(mate: Mate): Boolean {
    return find { friendship -> friendship.receiver == mate.email }?.status == FriendshipStatus.Pending
}

sealed interface FriendshipStatus {

    companion object {
        fun find(value: String): FriendshipStatus = when (value) {
            "pending" -> Pending
            "blocked" -> Blocked
            "accepted" -> Accepted
            "standard_unknown" -> StandardUnknown
            else -> Unknown(value)
        }
    }

    fun value(): String

    data object Pending : FriendshipStatus {
        override fun value(): String {
            return "pending"
        }
    }

    data object Blocked : FriendshipStatus {
        override fun value(): String {
            return "blocked"
        }
    }

    data object Accepted : FriendshipStatus {
        override fun value(): String {
            return "accepted"
        }
    }

    data object StandardUnknown : FriendshipStatus {
        override fun value(): String {
            return "standard_unknown"
        }
    }

    data class Unknown(val value: String) : FriendshipStatus {
        override fun value(): String {
            return "unknown"
        }
    }
}