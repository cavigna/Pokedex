package com.example.pokedexmvvm.model.api.pokemon


import com.google.gson.annotations.SerializedName

data class Version(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)