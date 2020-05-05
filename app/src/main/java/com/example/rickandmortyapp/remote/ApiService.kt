package com.example.rickandmortyapp.remote

import com.example.rickandmortyapp.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    fun getCharacters(): Response<CharacterResponse>
}
