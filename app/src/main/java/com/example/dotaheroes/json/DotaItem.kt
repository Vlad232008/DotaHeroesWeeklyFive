package com.example.dotaheroes.json


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DotaItem(
    val id: Int,
    @Json(name = "attack_type")
    val attackType: String,
    @Json(name = "legs")
    val legs: Int,
    @Json(name = "localized_name")
    val localizedName: String,
    val name: String,
    @Json(name = "primary_attr")
    val primaryAttr: String,
    @Json(name = "roles")
    val roles: List<String>
)