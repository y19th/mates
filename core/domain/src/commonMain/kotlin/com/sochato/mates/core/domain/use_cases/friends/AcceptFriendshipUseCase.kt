package com.sochato.mates.core.domain.use_cases.friends

import com.sochato.mates.core.data.model.request.AcceptFriendshipRequest
import com.sochato.mates.core.data.repository.FriendsRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.models.WrummyDispatchers
import kotlinx.coroutines.withContext

class AcceptFriendshipUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: FriendsRepository
): BaseUseCase(dispatchers) {
    suspend operator fun invoke(friendshipId: Int) = withContext(context) {
        repository.acceptFriendship(AcceptFriendshipRequest(friendshipId))
    }
}