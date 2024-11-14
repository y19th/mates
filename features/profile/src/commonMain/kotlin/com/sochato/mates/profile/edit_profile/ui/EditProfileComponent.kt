package com.sochato.mates.profile.edit_profile.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.value.Value
import com.sochato.mates.core.domain.use_cases.profile.UpdateProfileUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.local.debugMessage
import com.sochato.mates.core.util.local.findWrummyException
import com.sochato.mates.core.util.models.SnackState
import com.sochato.mates.profile.edit_profile.domain.events.EditProfileEvents
import com.sochato.mates.profile.edit_profile.domain.state.EditProfileState
import com.sochato.mates.profile.edit_profile.slot.ui.EditPhotoComponent
import com.sochato.mates.profile.profile.domain.model.ProfileConfig
import com.sochato.mates.profile.root.RootProfileNavigator
import com.sochato.mates.profile.shared.imageAsFormData
import kotlinx.serialization.Serializable

internal class EditProfileComponent(
    componentContext: ComponentContext,
    config: ProfileConfig,
    private val profileNavigator: RootProfileNavigator,
    private val updateProfile: UpdateProfileUseCase
) : ScreenComponent<EditProfileState, EditProfileEvents>(
    initialState = EditProfileState(config),
    componentContext = componentContext
) {
    private val dialogNavigation = SlotNavigation<DialogConfiguration>()
    val dialog: Value<ChildSlot<*, EditPhotoComponent>> = childSlot(
        source = dialogNavigation,
        serializer = DialogConfiguration.serializer(),
        handleBackButton = true
    ) { _, childComponentContext ->
        EditPhotoComponent(
            componentContext = childComponentContext,
            onDismissed = dialogNavigation::dismiss,
            updateImage = { uri ->
                update { it.copy(profileIcon = uri) }
            }
        )
    }

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
                        profileDescription = event.newValue
                    )
                }
            }

            EditProfileEvents.OnOpenEditPhotoSheet -> {
                dialogNavigation.activate(DialogConfiguration)
            }

            EditProfileEvents.OnValidate -> {
                if (isValid()) {
                    launchIO {
                        with(state.value) {
                            updateProfile(
                                nickname = nickname,
                                description = profileDescription,
                                imagePart = if (profileIcon != null) imageAsFormData(profileIcon) else null
                            )
                        }.onSuccess {
                            snackEffect(SnackState.success("success"))
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

    @Serializable
    private data object DialogConfiguration
}