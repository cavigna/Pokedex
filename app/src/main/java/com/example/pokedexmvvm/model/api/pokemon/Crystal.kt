package com.example.pokedexmvvm.model.api.pokemon


import com.google.gson.annotations.SerializedName

data class Crystal(
    @SerializedName("back_default")
    val backDefault: String,
    @SerializedName("back_shiny")
    val backShiny: String,
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("front_shiny")
    val frontShiny: String
)