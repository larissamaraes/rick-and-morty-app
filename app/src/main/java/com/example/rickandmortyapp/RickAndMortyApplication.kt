package com.example.rickandmortyapp

import android.app.Application
import androidx.room.Room
import com.example.rickandmortyapp.remote.AppDatabase
import com.facebook.stetho.Stetho

class RickAndMortyApplication : Application() {

    companion object {
        var database: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "rick-and-morty-app-db"
        ).build()
        val initializerBuilder = Stetho.newInitializerBuilder(this)
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
        val initializer = initializerBuilder.build()
        Stetho.initialize(initializer)
    }
}
