package com.example.flowretrofit.data.models

import com.example.flowretrofit.data.network.responces.Result

data class PokedexListEntry(
    val pokemonName: String,
    val imageUrl: String,
    val number: Int
)

data class PokemonListEntries(
    val endReached: Boolean,
    val results: List<PokedexListEntry>
)