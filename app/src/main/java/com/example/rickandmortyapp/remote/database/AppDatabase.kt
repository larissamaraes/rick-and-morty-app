package com.example.rickandmortyapp.remote.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortyapp.dao.CharacterDao
import com.example.rickandmortyapp.model.Character

@Database(entities = [Character::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
