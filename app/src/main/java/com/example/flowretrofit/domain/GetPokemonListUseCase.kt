package com.example.flowretrofit.domain

import com.example.flowretrofit.data.Constants
import com.example.flowretrofit.data.models.PokedexListEntry
import com.example.flowretrofit.data.models.PokemonListEntries
import com.example.flowretrofit.data.network.Resource
import com.example.flowretrofit.data.network.repository.PokemonRepository
import com.example.flowretrofit.data.network.responces.PokemonList
import com.example.flowretrofit.data.network.responces.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Locale
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository
){
    suspend fun getPokemonList(limit: Int, offset: Int, curPage:Int): Flow<Resource<PokemonListEntries>> {
        return repository.getPokemonList(limit, offset).map { resource: Resource<PokemonList> ->
            when(resource) {
                is Resource.Error -> return@map Resource.Error(resource.message?:"Error")
                is Resource.Loading -> return@map Resource.Loading()
                is Resource.Success -> {
                    if( resource.data?.results != null ) {
                        val pokedexEntries : List<PokedexListEntry> =
                            resource.data.results.mapIndexed { index : Int, entry: Result ->
                                val number = if(entry.url.endsWith("/")) {
                                    entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                                } else {
                                    entry.url.takeLastWhile { it.isDigit() }
                                }
                                val url = "${Constants.SPRITES_BASE_URL}${number}.png"
                                PokedexListEntry(entry.name.capitalize(Locale.ROOT), url, number.toInt())
                            }
                        val endReached = curPage * limit >= resource.data.count
                        return@map Resource.Success(
                            PokemonListEntries(endReached = endReached, pokedexEntries)
                        )
                    } else {
                        return@map Resource.Success(PokemonListEntries(endReached = true, emptyList()))
                    }

                }
            }
        }
    }
}