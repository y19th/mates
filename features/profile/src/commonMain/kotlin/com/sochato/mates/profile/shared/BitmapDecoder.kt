package com.sochato.mates.profile.shared

import io.ktor.client.request.forms.FormPart

expect fun imageAsFormData(uri: String): FormPart<ByteArray>