package com.sochato.mates.core.domain.use_cases.friends

import com.sochato.mates.core.data.model.request.FriendshipRequest
import com.sochato.mates.core.data.repository.FriendsRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.models.WrummyDispatchers
import kotlinx.coroutines.withContext

class RequestFriendshipUseCase(
    dispatchers: WrummyDispatchers,
    private val friendsRepository: FriendsRepository
) : BaseUseCase(dispatchers) {

    suspend operator fun invoke(email: String) = withContext(context) {
        friendsRepository.requestFriendship(FriendshipRequest(email))
    }
}