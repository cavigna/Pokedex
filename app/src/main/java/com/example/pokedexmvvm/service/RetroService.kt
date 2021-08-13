package com.example.pokedexmvvm.service

import com.example.pokedexmvvm.model.api.pokelist.PokeList

import retrofit2.Response
import retrofit2.http.GET

interface RetroService {

    @GET("pokemon?limit=151")
    suspend fun pokelist(): PokeList

}


//https://pokeapi.co/api/v2/pokemon?limit=151

