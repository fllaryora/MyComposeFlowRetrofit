package com.example.flowretrofit.di

import com.example.flowretrofit.data.network.ApiClient.apiService
import com.example.flowretrofit.data.network.PokemonApiService
import com.example.flowretrofit.data.network.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providePokeApi(): PokemonApiService {
        return apiService
    }

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokemonApiService
    ) = PokemonRepository(api)
}