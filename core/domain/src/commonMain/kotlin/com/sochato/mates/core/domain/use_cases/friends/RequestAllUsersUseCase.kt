package com.sochato.mates.core.domain.use_cases.friends

import com.sochato.mates.core.data.model.response.MateResponse
import com.sochato.mates.core.data.repository.FriendsRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toMateModel
import com.sochato.mates.core.domain.models.Friendship
import com.sochato.mates.core.domain.models.FriendshipStatus
import com.sochato.mates.core.domain.models.WrummyDispatchers
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.withContext

class RequestAllUsersUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: FriendsRepository,
    private val requestFriends: RequestFriendsUseCase
) : BaseUseCase(dispatchers) {

    suspend operator fun invoke() = withContext(context) {
        repository.requestAllUsers()
            .mapCatching { users ->
                requestFriends().getOrThrow().let { friendship ->
                    users
                        .map { it.toMateModel(status = friendship.findStatusByMate(it)) }
                        .toImmutableList()
                }
            }
    }
}

private fun List<Friendship>.findStatusByMate(mate: MateResponse): FriendshipStatus {
    return find { friendship -> friendship.receiver == mate.email || friendship.sender == mate.email }?.status
        ?: FriendshipStatus.StandardUnknown
}