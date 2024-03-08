package com.example.flowretrofit.data.network.responces.pokemon

import com.google.gson.annotations.SerializedName

data class Ability(
    val ability: AbilityX,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    val slot: Int
)

data class AbilityX(
    val name: String,
    val url: String
)
