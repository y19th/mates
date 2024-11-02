package com.sochato.mates.core.util.local

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.sochato.mates.core.util.extension.decode
import com.sochato.mates.core.util.extension.encode
import com.sochato.mates.core.util.models.BuildProperties

object MatesSettings {

    private val settings: Settings = Settings()

    var properties: BuildProperties
        get() = settings[Keys.BUILD_PROPERTIES, BuildProperties.Default].decode()
        set(value) = settings.putString(Keys.BUILD_PROPERTIES, value.encode())

    var onboardingCleared: Boolean
        get() = settings[Keys.ONBOARDING, false]
        set(value) = settings.putBoolean(Keys.ONBOARDING, value)

    var firstHomeLaunch: Boolean
        get() = settings[Keys.HOME, false]
        set(value) = settings.putBoolean(Keys.HOME, value)
}

private object Keys {

    const val BUILD_PROPERTIES = "build_properties"
    const val HOME = "first_home"
    const val ONBOARDING = "onboarding"
}