package com.example.flowretrofit.data.network.responces.pokemon

data class Type(
    val slot: Int,
    val type: TypeX
)

data class TypeX(
    val name: String,
    val url: String
)
