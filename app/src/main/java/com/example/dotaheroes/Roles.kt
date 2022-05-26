package com.example.dotaheroes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Roles(
    @Json(name = "name")
    val name: String
)
