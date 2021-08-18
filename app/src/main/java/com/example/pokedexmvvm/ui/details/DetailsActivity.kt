package com.example.pokedexmvvm.ui.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.pokedexmvvm.repository.PokeApiRepository
import com.example.pokedexmvvm.service.RetroInstance
import com.example.pokedexmvvm.ui.details.ui.theme.PokedexMVVMTheme


class DetailsActivity : ComponentActivity() {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var factory: DetailViewModelFactory

    private val repository = PokeApiRepository(RetroInstance.retroService)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nombre = intent.getStringExtra("nombre").toString()


        val factoryDetailViewModel = DetailViewModelFactory(repository, nombre)

        detailViewModel = ViewModelProvider(this, factoryDetailViewModel).get(DetailViewModel::class.java)
        // pokeInfo = detailViewModel.pokeMutableState.value
        setContent {

            PokedexMVVMTheme {

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    prueba(detailViewModel)
                //PokemonDetails(pokeInfo)
                //detailViewModel.pokeInfo.value?.let { PokemonDetails(it) }
                }
            }
        }

    }


     fun getpoke(pokeNombre: String){

        detailViewModel.getPoke(pokeNombre)


    }


//    @Composable
//    fun initPoke(detailViewModel: DetailViewModel, pokeNombre:String){
//
//
//        val poke: State<Pokemon?> = detailViewModel.pokeInfo.observeAsState()
//
//        PokemonDetails(pokeInfo = poke.value!!, modifier = Modifier, name = pokeNombre)
//
//
//    }
}

@Composable
fun prueba(detailViewModel: DetailViewModel){
val poke by detailViewModel.pokeInfo.observeAsState()
    if (poke== null){
        CircularProgressIndicator()
    }
    else{
        PokemonDetails(poke!!, Modifier)
    }
}










//@Composable
//    fun pokeRespuesta(pokeNombre:String){
//    composableScope.launch{
//        detailViewModel.fillPokeInfo(pokeNombre)
//
//        detailViewModel.pokeInfo.observe(this@DetailsActivity){
//            PokemonDetails(pokeInfo = detailViewModel.pokeInfo.value!!)
//        }
//    }
//    }
//
//}


//    @Preview(showBackground = true)
//    @Composable
//    fun DefaultPreview() {
//        PokedexMVVMTheme {
//            Greeting("Android")
//
//        }
//
//
//    }


/*
setContent {
            PokedexMVVMTheme {
                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
 */

/*
class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexMVVMTheme {
        Greeting("Android")
    }
}
 */

/*

    @Preview(showBackground = true)
    @Composable
    fun pruebaPreview() {
        seccionPokePrueba()
        //FilasColumnas()
    }

    @Composable
    fun FilasColumnas() {

        Column {
            Row {
                imagenPoke()
            }
            Row {
                Column {
                    imagenPoke()
                }
                nombrePoke()
            }

            Row {
                Text("Otro mas")
            }
        }


    }

    @Composable
    fun seccionPokePrueba() {


        Box() {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                imagenPoke()
                nombrePoke()
                TipoSeccion()

            }

            Row {
                Text("seeeeeeeeeeeeee")
            }
        }



    }

    @Composable
    fun imagenPoke() {


        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.size(150.dp).padding(2.dp).clip(CircleShape),
                painter = painterResource(R.drawable.bulbasur),
                contentDescription = "bublaSur",

                )
        }


    }

    @Composable
    fun nombrePoke() {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Text("Bulbasaur", color = Color.LightGray, fontSize = 20.sp)
        }

    }

    @Composable
    fun TipoSeccion() {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(20.dp)) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f).clip(CircleShape).background(Colores.TypeGrass)
            ) {
                Text("GRASS", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
                    .clip(CircleShape).
                    background(Colores.TypeGrass)
                    .padding(horizontal = 10.dp)
            ) {
                Text("GRASS", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(20.dp)){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

            ){
                Icon(painter= painterResource(R.drawable.ic_height), contentDescription = null)
            }
            Spacer(
                modifier = Modifier
                    .size(80.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                ){
                Icon(painter= painterResource(R.drawable.ic_weight), contentDescription = null)
            }
        }

    }


    @Preview(showBackground = true)
    @Composable
    fun otrapreviewmas(){
        otramas()
    }

    @Composable
    fun otramas(){
        Box(modifier = Modifier.fillMaxSize()){
            Surface(color = MaterialTheme.colors.primary){
                Text("hola")
            }
        }

        Box(modifier = Modifier.fillMaxSize()){
            Surface(color = MaterialTheme.colors.primary){
                Text("Chau")
            }
        }
    }
 */


/*

class DetailsActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val nombre = intent.getStringExtra("nombre").toString()

        val repository = PokeApiRepository(RetroInstance.retroService)


        lifecycleScope.launch(Main) {

            val pokeres = repository.pokeInfo(nombre)
            setContent {
                PokedexMVVMTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {

                        PokemonDetails(pokeres, Modifier)
                    }
                }
            }

        }

    }




}


 */