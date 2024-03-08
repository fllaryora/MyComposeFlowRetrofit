package com.example.flowretrofit.data.network

import com.example.flowretrofit.data.network.RetrofitClient.retrofit
object ApiClient {
    val apiService: PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java)
    }
}