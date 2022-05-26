package com.example.dotaheroes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlin.collections.List

@JsonClass(generateAdapter = true)
data class DotaHeroes(
    @Json(name = "array")
    val heroes: List<Heroes>
)
