package com.example.pokedexmvvm

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedexmvvm.databinding.CardPokemonBinding
import com.example.pokedexmvvm.model.api.pokelist.PokeList
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.request.ImageRequest
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.coroutineContext

class MainAdapter(val pokeList: PokeList): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private val currentPokemon = pokeList.pokeResult

    inner class MainViewHolder (val binding: CardPokemonBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            CardPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        var urlImage ="https://raw.githubusercontent.com/" +
                "PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${position + 1}.png"


        val contexto = holder.itemView.context
        //var request = ImageRequest.Builder().data
        //colorTarjeta(holder.binding.imageViewPoke.load(urlImage))

//        val palette = Palette.Builder().generate { palette: Palette? ->
//
//        }

        holder.binding.apply{
            textViewNombre.text = pokeList.pokeResult[position].name
            imageViewPoke.load(urlImage)

//            val loader = ImageLoader(contexto)
//            val request = ImageRequest.Builder(contexto)
//                .data(urlImage).target { resultado->
//                    val dibujo =(resultado as BitmapDrawable).bitmap
//                }
//                .build()
//
//            val result = (loader.execute(request) as SuccessResult).drawable
//            val bitmap = (result as BitmapDrawable).bitmap
        }
    }

    override fun getItemCount(): Int {
       return currentPokemon.size
    }

    fun colorTarjeta(drawable: BitmapDrawable){
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bmp).generate{ palette ->
            palette?.dominantSwatch?.rgb?.let {
                Color()
            }

        }
    }
}


/*
    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
 */