package com.example.pokedexmvvm.model.api.pokelist


import com.google.gson.annotations.SerializedName

data class PokeList(

    @SerializedName("results")
    val pokeResult: List<PokeResult>
)

/*
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
 */