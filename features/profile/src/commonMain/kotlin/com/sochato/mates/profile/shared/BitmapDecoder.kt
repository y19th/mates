package com.sochato.mates.profile.shared

import io.ktor.client.request.forms.FormPart

expect fun decodeBitmap(uri: String): ByteArray

expect fun imageAsFormData(uri: String): FormPart<ByteArray>