package com.sochato.mates.core.util.extension

fun String.toIntOrElse(another: Int): Int {
    return toIntOrNull() ?: another
}