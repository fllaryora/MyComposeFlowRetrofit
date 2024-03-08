package com.example.flowretrofit.data.network.responces

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)
