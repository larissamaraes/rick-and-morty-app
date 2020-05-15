package com.example.rickandmortyapp.model

import com.google.gson.annotations.SerializedName

class EpisodeResponse (
    val info: RequestInfo,
    @SerializedName("results")
    val locations: List<Episode>
)
