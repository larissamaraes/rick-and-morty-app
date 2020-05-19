package com.example.rickandmortyapp

import android.app.Application
import androidx.room.Room
import com.example.rickandmortyapp.remote.AppDatabase

class RickAndMortyApplication : Application() {
    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "rick-and-morty-app-db"
        )
            .build()
    }
}
