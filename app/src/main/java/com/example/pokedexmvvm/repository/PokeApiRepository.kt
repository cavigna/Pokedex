package com.example.pokedexmvvm.repository

import com.example.pokedexmvvm.model.api.pokemon.Pokemon
import com.example.pokedexmvvm.service.RetroService
import com.example.pokedexmvvm.utils.Resource

class PokeApiRepository(val retroService: RetroService) {

    suspend fun pokeList() = retroService.pokelist()

    suspend fun pokeInfo(nombre:String) = retroService.pokeInfo(nombre)

    suspend fun pokeInfoResource(nombre:String) = retroService.pokeInfoResource(nombre)

//    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
//        val response = try {
//            retroService.pokeInfo(pokemonName)
//        } catch(e: Exception) {
//            return Resource.Error("An unknown error occured.")
//        }
//        return Resource.Success(response)
 //   }
}