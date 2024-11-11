package com.sochato.mates.core.util.local

sealed class WrummyException(override val message: String) : Throwable() {

    companion object {
        fun find(value: String) = when (value) {
            NetworkError.message -> NetworkError
            InvalidCredentialsError.message -> InvalidCredentialsError
            else -> UnknownError
        }
    }

    data object NetworkError : WrummyException("network error")

    data object InvalidCredentialsError: WrummyException("invalid credentials")

    data object InternalServerError: WrummyException("something went wrong")

    data object UnknownError : WrummyException("unknown error")

    class CustomError(message: String): WrummyException(message)
}

fun Throwable.toWrummyException(): WrummyException {
    return if (message != null)
        WrummyException.find(requireNotNull(message))
    else
        WrummyException.UnknownError
}

fun Throwable.findWrummyException(): WrummyException {
    if(message == null) return WrummyException.UnknownError
    if(this is WrummyException.CustomError) return this

    return if (requireNotNull(message).contains("network"))
        WrummyException.NetworkError
    else if(requireNotNull(message).contains("credential"))
        WrummyException.InvalidCredentialsError
    else
        WrummyException.UnknownError
}