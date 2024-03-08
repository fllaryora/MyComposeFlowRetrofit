package com.example.flowretrofit.data.network.responces.pokemon

import com.google.gson.annotations.SerializedName

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: StatX
)
data class StatX(
    val name: String,
    val url: String
)
