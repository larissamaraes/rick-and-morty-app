package com.example.rickandmortyapp.model.converter

import androidx.room.TypeConverter
import java.util.*

class DateConverters {
    @TypeConverter
    fun fromTimestamp(value: Long): Date = Date(value)

    @TypeConverter
    fun toTimestamp(date: Date): Long = date.time
}
