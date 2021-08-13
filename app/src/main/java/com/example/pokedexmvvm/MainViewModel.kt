package com.example.pokedexmvvm

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.pokedexmvvm.model.api.pokelist.PokeList
import com.example.pokedexmvvm.repository.PokeApiRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainViewModel(val repository: PokeApiRepository) :ViewModel(){

    private var _listadoPokemon = MutableLiveData<PokeList>()

    val listadoPokemon:LiveData<PokeList> = _listadoPokemon

    fun pokelist(){
        viewModelScope.launch(IO) {
            _listadoPokemon.postValue(repository.pokeList())
        }
    }


    fun colorTarjeta(drawable: BitmapDrawable){
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bmp).generate{ palette ->
            palette?.dominantSwatch?.rgb?.let {
                Color()
            }

        }
    }

//    private suspend fun  getBitmap(urlImage:String):Bitmap{
//        val loading= ImageLoader(requireContext())
//        val request= ImageRequest.Builder(requireContext())
//            .data(urlImage)
//            .build()
//        val result = (loading.execute(request) as SuccessResult).drawable
//        return(result as BitmapDrawable).bitmap
//    }

}