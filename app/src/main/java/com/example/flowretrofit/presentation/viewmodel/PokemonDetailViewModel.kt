package com.example.flowretrofit.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.flowretrofit.data.network.Resource
import com.example.flowretrofit.data.network.repository.PokemonRepository
import com.example.flowretrofit.data.network.responces.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}