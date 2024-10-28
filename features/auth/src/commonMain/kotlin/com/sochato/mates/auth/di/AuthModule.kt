package com.sochato.mates.auth.di

import com.sochato.mates.auth.acquaintance.ui.AcquaintanceComponent
import com.sochato.mates.auth.forgot_password.ui.ForgotPasswordComponent
import com.sochato.mates.auth.login.ui.LoginComponent
import com.sochato.mates.auth.root.ui.AuthComponent
import com.sochato.mates.auth.sign_up.ui.SignUpComponent
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val authModule = module {
    factoryOf(::AuthComponent)
    factoryOf(::LoginComponent)
    factoryOf(::SignUpComponent)
    factoryOf(::ForgotPasswordComponent)
    factoryOf(::AcquaintanceComponent)
}