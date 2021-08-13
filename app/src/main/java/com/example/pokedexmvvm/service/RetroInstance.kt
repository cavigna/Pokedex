package com.example.pokedexmvvm.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {

    const val BASE_URL ="https://pokeapi.co/api/v2/"

    val retroService:RetroService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetroService::class.java)
    }


}