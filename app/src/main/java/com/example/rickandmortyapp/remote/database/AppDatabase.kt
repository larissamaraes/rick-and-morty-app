package com.example.rickandmortyapp.remote.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rickandmortyapp.dao.CharacterDao
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.model.converter.DateConverters

@Database(entities = [Character::class], version = 1)
@TypeConverters(DateConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
