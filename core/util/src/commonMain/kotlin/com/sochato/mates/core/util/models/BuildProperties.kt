package com.sochato.mates.core.util.models

import com.sochato.mates.core.util.extension.encode
import kotlinx.serialization.Serializable

@Serializable
data class BuildProperties(
    val name: String,
    val code: Int
) {
    companion object {
        val Default = BuildProperties("", 1).encode()
    }
}

fun BuildProperties.versionName() = "v$name"
