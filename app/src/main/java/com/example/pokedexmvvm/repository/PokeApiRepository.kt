package com.example.pokedexmvvm.repository

import com.example.pokedexmvvm.service.RetroService

class PokeApiRepository(val retroService: RetroService) {

    suspend fun pokeList() = retroService.pokelist()
}