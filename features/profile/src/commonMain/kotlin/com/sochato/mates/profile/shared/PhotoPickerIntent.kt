package com.sochato.mates.profile.shared

import androidx.compose.runtime.Composable

@Composable
expect fun PickPhoto(onResult: (String) -> Unit)