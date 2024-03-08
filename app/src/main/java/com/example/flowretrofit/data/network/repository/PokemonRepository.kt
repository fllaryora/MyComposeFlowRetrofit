package com.example.flowretrofit.data.network.repository

import com.example.flowretrofit.data.network.PokemonApiService
import com.example.flowretrofit.data.network.Resource
import com.example.flowretrofit.data.network.responces.Pokemon
import com.example.flowretrofit.data.network.responces.PokemonList
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor (private val api: PokemonApiService) {
    suspend fun getPokemonList(limit: Int, offset: Int): Flow<Resource<PokemonList>> {
        return flow <Resource<PokemonList>>{
            try {
                val response = api.getPokemonList(limit, offset)
                emit(
                    Resource.Success(response)
                )
            } catch(exception: Exception) {
                emit(
                    Resource.Error(exception.message?:"An unknown error occured.")
                )
            }

        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPokemonInfo(pokemonName: String): Flow<Resource<Pokemon>> {
        return flow <Resource<Pokemon>>{
            try {
                val response = api.getPokemonInfo(pokemonName)
                emit(
                    Resource.Success(response)
                )
            } catch(exception: Exception) {
                emit(
                    Resource.Error(exception.message?:"An unknown error occured.")
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}