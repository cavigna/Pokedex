package com.example.pokedexmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.pokedexmvvm.appcontainer.PokeApplication
import com.example.pokedexmvvm.databinding.ActivityMainBinding
import com.example.pokedexmvvm.repository.PokeApiRepository
import com.example.pokedexmvvm.service.RetroInstance
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var repository: PokeApiRepository
    private lateinit var factory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel
   // private lateinit var adapterUno: MainAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = PokeApiRepository(RetroInstance.retroService)
        factory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        getPokeList()
        initRecycler()


//        val appContainer = (application as PokeApplication).appContainer
//        val viewModel = MainViewModel(appContainer.repository)
//
//        val verga = appContainer.viewModelFactory.create(appContainer.repository)




    }


    private fun getPokeList(){
        lifecycleScope.launch {
            val response = RetroInstance.retroService.pokelist()

            Log.v("SALIO", response.toString())
        }
    }

    private fun initRecycler(){
        val recycler = binding.recyclerMain
        viewModel.pokelist()

        viewModel.listadoPokemon.observe(this){
            recycler.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = MainAdapter(it)
            }
        }
    }
}