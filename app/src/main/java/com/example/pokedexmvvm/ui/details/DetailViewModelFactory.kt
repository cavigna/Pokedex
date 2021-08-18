package com.example.pokedexmvvm.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedexmvvm.repository.PokeApiRepository


class DetailViewModelFactory(private val repository: PokeApiRepository, val pokeNombre:String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(repository, pokeNombre) as T
    }
}

