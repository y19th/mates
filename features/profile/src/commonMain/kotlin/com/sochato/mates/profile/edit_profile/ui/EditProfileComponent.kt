package com.sochato.mates.profile.edit_profile.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.domain.use_cases.profile.UpdateProfileUseCase
import com.sochato.mates.core.util.base_components.EffectComponent
import com.sochato.mates.core.util.local.debugMessage
import com.sochato.mates.core.util.local.findWrummyException
import com.sochato.mates.core.util.models.SnackState
import com.sochato.mates.profile.edit_profile.domain.effect.EditProfileEffect
import com.sochato.mates.profile.edit_profile.domain.events.EditProfileEvents
import com.sochato.mates.profile.edit_profile.domain.state.EditProfileState
import com.sochato.mates.profile.profile.domain.model.ProfileConfig
import com.sochato.mates.profile.root.RootProfileNavigator

internal class EditProfileComponent(
    componentContext: ComponentContext,
    config: ProfileConfig,
    private val profileNavigator: RootProfileNavigator,
    private val updateProfile: UpdateProfileUseCase
) : EffectComponent<EditProfileState, EditProfileEvents, EditProfileEffect>(
    initialState = EditProfileState(config),
    componentContext = componentContext
) {
    override fun handleEvent(event: EditProfileEvents) {
        when (event) {
            EditProfileEvents.OnNavigateBack -> {
                navigate { profileNavigator.pop() }
            }

            is EditProfileEvents.OnNicknameChange -> {
                update {
                    it.copy(
                        nickname = event.newValue,
                        isNicknameError = event.newValue.isEmpty()
                    )
                }
            }

            is EditProfileEvents.OnStatusChange -> {
                update {
                    it.copy(
                        status = event.newValue
                    )
                }
            }

            EditProfileEvents.OnValidate -> {
                if (isValid()) {
                    launchIO {
                        with(state.value) {
                            updateProfile(
                                nickname = nickname,
                                description = status,
                                imageUrl = profileIcon
                            )
                        }.onSuccess {
                            snackEffect(SnackState.success("success"))
                            sideEffect(EditProfileEffect.OnSuccessEditProfileEffect(it))
                            navigate {
                                profileNavigator.pop()
                            }
                        }.onFailure {
                            debugMessage(it.stackTraceToString())
                            snackEffect(SnackState.failure(it.findWrummyException().message))
                        }
                    }
                }
            }
        }
    }

    private fun isValid(): Boolean {
        with(state.value) {
            return nickname.isNotEmpty() && !isNicknameError
        }
    }
}