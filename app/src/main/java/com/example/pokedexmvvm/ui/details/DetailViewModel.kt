package com.example.pokedexmvvm.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexmvvm.model.api.pokemon.Pokemon
import com.example.pokedexmvvm.repository.PokeApiRepository
import com.example.pokedexmvvm.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(val repository: PokeApiRepository, val pokeNombre: String): ViewModel() {

    private var _pokeInfo : MutableLiveData<Pokemon> = MutableLiveData<Pokemon>()
    val pokeInfo :LiveData<Pokemon> = _pokeInfo

//     var pokeMutableState : MutableState<Pokemon> = mutableStateOf(Pokemon())




    init {
        viewModelScope.launch {
            val result = repository.retroService.pokeInfo(pokeNombre)
            _pokeInfo.value = result
            //pokeMutableState.value = result
        }
    }

    suspend fun funGetPokemon(pokeNombre:String): Pokemon{



        return repository.pokeInfo(pokeNombre)
    }

    fun getPoke(pokeNombre: String){
        viewModelScope.launch(Dispatchers.IO) {
            _pokeInfo.postValue(repository.pokeInfo(pokeNombre))
        }
    }

    suspend fun fillPokeInfo(pokeNombre:String){
        _pokeInfo.postValue(
            repository.pokeInfo(pokeNombre)
        )
    }

    suspend fun funGetResourcePokemon(pokeNombre:String): Resource<Pokemon>{

        return repository.pokeInfoResource(pokeNombre)
    }

     suspend fun otromas(pokeNombre:String){
        _pokeInfo.value = repository.pokeInfo(pokeNombre)

    }


}