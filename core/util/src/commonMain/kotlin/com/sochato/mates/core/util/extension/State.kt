package com.sochato.mates.core.util.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow

@Composable
fun <T> StateFlow<T>.collectAsImmediateState(): State<T> {
    return collectAsState(Dispatchers.Main.immediate)
}