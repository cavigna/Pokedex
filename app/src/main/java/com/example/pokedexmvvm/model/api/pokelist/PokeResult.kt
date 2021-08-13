package com.example.pokedexmvvm.model.api.pokelist


import com.google.gson.annotations.SerializedName

data class PokeResult(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)