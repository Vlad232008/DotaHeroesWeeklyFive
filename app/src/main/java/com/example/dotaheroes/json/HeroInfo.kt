package com.example.dotaheroes.json


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeroInfo(
    val id: Int,
    val name: String,
    val localized_name: String,
    val primary_attr: String,
    val attack_type: String,
    val roles: List<String>,
    val img: String,
    val icon: String,
    val base_health: Int,
    val base_health_regen: Double,
    val base_mana: Int,
    val base_mana_regen: Double,
    val base_armor: Double,
    val base_mr: Int,
    val base_attack_min: Int,
    val base_attack_max: Int,
    val base_str: Int,
    val base_agi: Int,
    val base_int: Int,
    val str_gain: Double,
    val agi_gain: Double,
    val int_gain: Double,
    val attack_range: Int,
    val projectile_speed: Int,
    val attack_rate: Double,
    val move_speed: Int,
    val cm_enabled: Boolean,
    val legs: Int,
    val hero_id: Int
    /*@Json(name = "1_pick")
    val pick1 : Int,
    @Json(name = "1_win")
    val win1 : Int,
    @Json(name = "2_pick")
    val pick2 : Int,
    @Json(name = "2_win")
    val win2 : Int,
    @Json(name = "3_pick")
    val pick3 : Int,
    @Json(name = "3_win")
    val win3 : Int,
    @Json(name = "4_pick")
    val pick4 : Int,
    @Json(name = "4_win")
    val win4 : Int,
    @Json(name = "5_pick")
    val pick5 : Int,
    @Json(name = "5_win")
    val win5 : Int,
    @Json(name = "6_pick")
    val pick6 : Int,
    @Json(name = "6_win")
    val win6 : Int,
    @Json(name = "7_pick")
    val pick7 : Int,
    @Json(name = "7_win")
    val win7 : Int,
    @Json(name = "8_pick")
    val pick8 : Int,
    @Json(name = "8_win")
    val win8 : Int,
    val null_pick: Int,
    val null_win: Int*/
)