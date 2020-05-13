package com.example.rickandmortyapp.remote

import com.example.rickandmortyapp.model.CharacterResponse
import com.example.rickandmortyapp.model.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResponse

    @GET("location/")
    suspend fun getLocations(@Query("page") page: Int): LocationResponse
}
