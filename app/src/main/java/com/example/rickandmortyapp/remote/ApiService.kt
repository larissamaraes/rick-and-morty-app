package com.example.rickandmortyapp.remote

import com.example.rickandmortyapp.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResponse
}
