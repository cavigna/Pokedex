package com.example.pokedexmvvm.appcontainer

import com.example.pokedexmvvm.ui.main.MainViewModelFactory
import com.example.pokedexmvvm.repository.PokeApiRepository
import com.example.pokedexmvvm.service.RetroService
import retrofit2.Retrofit

class AppContainer {
    private val BASE_URL = "https://pokeapi.co/api/v2/"

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
            .create(RetroService::class.java)

    val repository = PokeApiRepository(retrofit)

    val viewModelFactory = MainViewModelFactory(repository)
}