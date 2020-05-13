package com.example.rickandmortyapp.model

import com.google.gson.annotations.SerializedName

class LocationResponse (
    val info: RequestInfo,
    @SerializedName("results")
    val locations: List<Location>
)
