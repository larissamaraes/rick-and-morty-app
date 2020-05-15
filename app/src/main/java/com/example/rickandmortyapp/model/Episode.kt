package com.example.rickandmortyapp.model

import com.google.gson.annotations.SerializedName
import java.util.*

class Episode (
    val id: Long,
    val name: String,
    val episode: String,
    @SerializedName("air_date")
    val airDate: String,
    val characters: List<String>,
    val created: Date
)
