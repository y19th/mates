package com.sochato.mates.profile.di

import com.sochato.mates.profile.edit_profile.ui.EditProfileComponent
import com.sochato.mates.profile.external_profile.ui.ExternalProfileComponent
import com.sochato.mates.profile.friends.ui.FriendsComponent
import com.sochato.mates.profile.profile.ui.ProfileComponent
import com.sochato.mates.profile.root.ui.RootProfileComponent
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val profileModule = module {
    factoryOf(::RootProfileComponent)
    factoryOf(::ProfileComponent)
    factoryOf(::EditProfileComponent)
    factoryOf(::FriendsComponent)
    factoryOf(::ExternalProfileComponent)
}