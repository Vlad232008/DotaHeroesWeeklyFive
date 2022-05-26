package com.example.dotaheroes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Heroes(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "localized_name")
    val localized_name: String,
    @Json(name = "primary_attr")
    val primary_attr: String,
    @Json(name = "attack_type")
    val attack_type: String,
    @Json(name = "roles")
    val roles: List<String>,
    @Json(name = "legs")
    val legs: Int
)


