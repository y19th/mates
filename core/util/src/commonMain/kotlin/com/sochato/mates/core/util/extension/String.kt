package com.sochato.mates.core.util.extension

fun String.isMatchEmailPattern(): Boolean {
    if (this.isEmpty()) return false
    val emailAddressRegex = Regex(
        "[a-zA-Z0-9+._%\\-]{1,256}" +
                "@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    return this.matches(emailAddressRegex)
}

fun String.isNotMatchEmailPattern(): Boolean {
    return !this.isMatchEmailPattern()
}