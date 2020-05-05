package com.example.rickandmortyapp.model

import com.google.gson.annotations.SerializedName

class CharacterResponse (
    val info: RequestInfo,
    @SerializedName("results")
    val characters: List<Character>
)
