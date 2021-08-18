package com.example.pokedexmvvm.service

import com.example.pokedexmvvm.model.api.pokelist.PokeList
import com.example.pokedexmvvm.model.api.pokemon.Pokemon
import com.example.pokedexmvvm.utils.Resource
import retrofit2.http.GET
import retrofit2.http.Path

interface RetroService {

    @GET("pokemon?limit=151")
    suspend fun pokelist(): PokeList


    @GET("pokemon/{nombre}")
    suspend fun pokeInfo(@Path("nombre") nombre:String): Pokemon





    @GET("pokemon/{nombre}")
    suspend fun pokeInfoResource(@Path("nombre") nombre:String): Resource<Pokemon>
}



//https://pokeapi.co/api/v2/pokemon?limit=151

