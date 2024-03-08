package com.example.flowretrofit.presentation.viewmodel

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import com.example.flowretrofit.data.Constants.PAGE_SIZE
import com.example.flowretrofit.data.Constants.SPRITES_BASE_URL
import com.example.flowretrofit.data.models.PokedexListEntry
import com.example.flowretrofit.data.models.PokemonListEntries
import com.example.flowretrofit.data.network.Resource
import com.example.flowretrofit.data.network.responces.PokemonList
import com.example.flowretrofit.domain.GetPokemonListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val usecase: GetPokemonListUseCase
) : ViewModel() {

    private var curPage = 0

    var pokemonList = mutableStateOf<List<PokedexListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    private var cachedPokemonList = listOf<PokedexListEntry>()
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)

    init {
        loadPokemonPaginated()
    }

    fun loadPokemonPaginated() {
        viewModelScope.launch(Dispatchers.Main) {
            isLoading.value = true
            usecase.getPokemonList(PAGE_SIZE, curPage * PAGE_SIZE, curPage)
                .collect { result : Resource<PokemonListEntries> ->
                when(result) {
                    is Resource.Success -> {
                        endReached.value = result.data!!.endReached
                        curPage++

                        loadError.value = ""
                        isLoading.value = false
                        pokemonList.value += result.data.results
                    }
                    is Resource.Error -> {
                        loadError.value = result.message!!
                        isLoading.value = false
                    }

                    is Resource.Loading -> TODO()
                }
            }

        }
    }

    fun searchPokemonList(query: String) {
        val listToSearch = if(isSearchStarting) {
            pokemonList.value
        } else {
            cachedPokemonList
        }
        viewModelScope.launch(Dispatchers.Default) {
            if(query.isEmpty()) {
                pokemonList.value = cachedPokemonList
                isSearching.value = false
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                it.pokemonName.contains(query.trim(), ignoreCase = true) ||
                        it.number.toString() == query.trim()
            }
            if(isSearchStarting) {
                cachedPokemonList = pokemonList.value
                isSearchStarting = false
            }
            pokemonList.value = results
            isSearching.value = true
        }
    }

    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }
}