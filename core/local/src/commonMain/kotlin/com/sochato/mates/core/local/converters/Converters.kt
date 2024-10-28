package com.sochato.mates.core.local.converters

import androidx.room.TypeConverter
import com.sochato.mates.core.local.entities.CarEntity
import com.sochato.mates.core.local.entities.DetailItemEntity
import com.sochato.mates.core.local.entities.ListCarEntity
import com.sochato.mates.core.local.entities.NumberEntity
import com.sochato.mates.core.util.extension.decode
import com.sochato.mates.core.util.extension.encode
import com.sochato.mates.core.util.models.Transition

class TransitionConverter {

    @TypeConverter
    fun transitionToInt(value: Transition) = value.value()

    @TypeConverter
    fun intToTransition(value: Int) = Transition.find(value)
}

class UserConverter {

    @TypeConverter
    fun carToString(value: CarEntity): String = value.encode()

    @TypeConverter
    fun stringToCar(value: String): CarEntity = value.decode()

    @TypeConverter
    fun detailToString(value: DetailItemEntity): String = value.encode()

    @TypeConverter
    fun stringToDetail(value: String): DetailItemEntity = value.decode()

    @TypeConverter
    fun numberToString(value: NumberEntity): String = value.encode()

    @TypeConverter
    fun stringToNumber(value: String): NumberEntity = value.decode()

    @TypeConverter
    fun listCarsToString(value: ListCarEntity): String = value.encode()

    @TypeConverter
    fun stringToListCars(value: String): ListCarEntity = value.decode()
}









