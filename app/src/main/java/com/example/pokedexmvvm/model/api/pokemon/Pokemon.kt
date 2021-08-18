package com.example.pokedexmvvm.model.api.pokemon


import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("abilities")
    val abilities: List<Ability> ,

    @SerializedName("base_experience")
    val baseExperience: Int,

    @SerializedName("forms")
    val forms: List<Form> ,

    @SerializedName("game_indices")
    val gameIndices: List<GameIndice>,

    @SerializedName("height")
    val height: Int = 0,

    @SerializedName("held_items")
    val heldItems: List<Any> ,

    @SerializedName("id")
    val id: Int,

    @SerializedName("is_default")
    val isDefault: Boolean,

    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,

    @SerializedName("moves")
    val moves: List<Move>,

    @SerializedName("name")
    val name: String,

    @SerializedName("order")
    val order: Int,

    @SerializedName("past_types")
    val pastTypes: List<Any>,

    @SerializedName("species")
    val species: Species,

    @SerializedName("sprites")
    val sprites: Sprites,


    @SerializedName("stats")
    val stats: List<Stat>,

    @SerializedName("types")
    val types: List<Type>,

    @SerializedName("weight")
    val weight: Int = 0
)

/*      *** ORIGINAL


data class Pokemon(
    @SerializedName("abilities")
    val abilities: List<Ability> ,

    @SerializedName("base_experience")
    val baseExperience: Int,

    @SerializedName("forms")
    val forms: List<Form> ,

    @SerializedName("game_indices")
    val gameIndices: List<GameIndice>,

    @SerializedName("height")
    val height: Int = 0,

    @SerializedName("held_items")
    val heldItems: List<Any> ,

    @SerializedName("id")
    val id: Int,

    @SerializedName("is_default")
    val isDefault: Boolean,

    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,

    @SerializedName("moves")
    val moves: List<Move>,

    @SerializedName("name")
    val name: String,

    @SerializedName("order")
    val order: Int,

    @SerializedName("past_types")
    val pastTypes: List<Any>,

    @SerializedName("species")
    val species: Species,

    @SerializedName("sprites")
    val sprites: Sprites,


    @SerializedName("stats")
    val stats: List<Stat>,

    @SerializedName("types")
    val types: List<Type>,

    @SerializedName("weight")
    val weight: Int = 0
)

 */

/*
data class Pokemon(
    @SerializedName("abilities")
    val abilities: List<Ability> = emptyList(),

    @SerializedName("base_experience")
    val baseExperience: Int = 0,

    @SerializedName("forms")
    val forms: List<Form> = emptyList(),

    @SerializedName("game_indices")
    val gameIndices: List<GameIndice> = emptyList(),

    @SerializedName("height")
    val height: Int = 0,

    @SerializedName("held_items")
    val heldItems: List<Any> = emptyList(),

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("is_default")
    val isDefault: Boolean = true,

    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String = "",

    @SerializedName("moves")
    val moves: List<Move> = emptyList(),

    @SerializedName("name")
    val name: String = "",

    @SerializedName("order")
    val order: Int = 0,

    @SerializedName("past_types")
    val pastTypes: List<Any> = emptyList(),

    @SerializedName("species")
    val species: Species = Species("", ""),

    @SerializedName("sprites")
    val sprites: Sprites? = null,


    @SerializedName("stats")
    val stats: List<Stat> = emptyList(),

    @SerializedName("types")
    val types: List<Type> = emptyList(),

    @SerializedName("weight")
    val weight: Int = 0
)


 */