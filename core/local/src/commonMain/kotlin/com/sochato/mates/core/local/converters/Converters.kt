package com.sochato.mates.core.local.converters

import androidx.room.TypeConverter
import com.sochato.mates.core.util.models.Transition

class TransitionConverter {

    @TypeConverter
    fun transitionToInt(value: Transition) = value.value()

    @TypeConverter
    fun intToTransition(value: Int) = Transition.find(value)
}









