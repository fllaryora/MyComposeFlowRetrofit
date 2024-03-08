package com.example.flowretrofit.data.network.responces.pokemon

import com.google.gson.annotations.SerializedName

data class GameIndice(
    @SerializedName("game_index")
    val gameIndex: Int,
    val version: Version
)

data class Version(
    val name: String,
    val url: String
)