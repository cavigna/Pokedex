package com.example.pokedexmvvm.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedexmvvm.repository.PokeApiRepository


//interface Factory {
//    fun create(): T
//}

class MainViewModelFactory(private val repository: PokeApiRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
    }


/*

 override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }


 */