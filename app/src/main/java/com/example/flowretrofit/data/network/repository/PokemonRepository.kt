package com.example.flowretrofit.data.network.repository

import com.example.flowretrofit.data.network.PokemonApiService
import com.example.flowretrofit.data.network.Resource
import com.example.flowretrofit.data.network.responces.Pokemon
import com.example.flowretrofit.data.network.responces.PokemonList
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor (private val api: PokemonApiService) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch(e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch(exception: Exception) {
            return Resource.Error(exception.message?:"An unknown error occured.")
        }
        return Resource.Success(response)
    }
}