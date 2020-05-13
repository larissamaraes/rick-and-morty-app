package com.example.rickandmortyapp.model

import java.util.*

class Location(
    val id: Long,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val created: Date
)
