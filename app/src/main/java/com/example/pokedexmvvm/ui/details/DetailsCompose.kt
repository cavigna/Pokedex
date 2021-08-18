package com.example.pokedexmvvm.ui.details



import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.pokedexmvvm.R
import com.example.pokedexmvvm.model.api.pokemon.Pokemon
import com.example.pokedexmvvm.model.api.pokemon.Type
import com.example.pokedexmvvm.utils.parseStatToAbbr
import com.example.pokedexmvvm.utils.parseStatToColor
import com.example.pokedexmvvm.utils.parseTypeToColor
import java.lang.Math.round
import java.util.*





@Composable
fun PokemonDetails(
    //viewModel: DetailViewModel,
    //name:String,
    pokeInfo: Pokemon,
    modifier: Modifier = Modifier,
    topPadding: Dp = 20.dp,
    imageSize: Dp = 200.dp
) {

   Box(
        modifier = Modifier.fillMaxSize() //==>Main Container
            .background(color = Color.DarkGray)
            .padding(bottom = 16.dp)
    ) {
        DetailBody(
            pokeInfo = pokeInfo,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = (topPadding + imageSize) / 2f,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 6.dp,
                )
                .shadow(10.dp, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colors.surface)
                .padding(16.dp)
                .align(Alignment.BottomCenter)
                .size(100.dp)
                //.offset(y =((-20).dp))

        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter,

            ) {

            PokeTop(pokeInfo, imageSize)

        }
    }




}

@Composable
fun PokeTop(pokeInfo: Pokemon, imageSize: Dp) {

    val painter = rememberImagePainter(

        data = pokeInfo.sprites.frontDefault,
       // data = pokeInfo.sprites.other.officialArtwork,
        builder = {
            placeholder(R.drawable.bulbasur)
        }
    )

    val painterState = painter.state
    //CircularProgressIndicator()



        Image(painter = painter, contentDescription = "pokename", modifier = Modifier.size(imageSize))



}

@Composable
fun DetailBody(
    pokeInfo: Pokemon,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .offset(y = 50.dp)
            .verticalScroll(scrollState)
    ) {

        Text(
            text = "#${pokeInfo.id} ${pokeInfo.name.capitalize(Locale.ROOT)}",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,


            )


        PokeTypeSection(tipos = pokeInfo.types)

        //Spacer(modifier =Modifier.size(10.dp))

        PokeDataSection(
            pokePeso = pokeInfo.weight,
            pokeAltura = pokeInfo.height
        )
        PokeBaseStat(pokeInfo)

    }

}

@Composable
fun PokeTypeSection(
    tipos: List<Type>,

    ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)

    ) {

        for (type in tipos) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .clip(CircleShape)
                    .background(parseTypeToColor(type))
                    .height(35.dp)
            ) {
                Text(
                    text = type.type.name.capitalize(Locale.ROOT),
                    color = Color.White,
                    fontSize = 22.sp
                )

            }
        }
    }

}

@Composable
fun PokeDataSection(
    pokePeso: Int,
    pokeAltura: Int,
    sectionHeight: Dp = 80.dp
) {
    val pokeKg = remember {
        round(pokePeso * 100f) / 1000f
    }

    val pokeMts = remember {
        round(pokeAltura * 100f) / 1000f
    }
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        Icon(painterResource(R.drawable.ic_weight),null
        )


        PokeDataItem(
            dataValue = pokeKg,
            "Kg",
            dataIcon = painterResource(id = R.drawable.ic_weight),
            modifier = Modifier.weight(1f)
        )
        Spacer(
            modifier = Modifier
                .size(2.dp, sectionHeight)
                .background(Color.DarkGray)
               //.padding(end = 2.dp)
        )

        Icon(painterResource(R.drawable.ic_height),null
        )
        PokeDataItem(
            dataValue = pokeMts,
            "Mts",
            dataIcon = painterResource(id = R.drawable.ic_height),
            modifier = Modifier.weight(1f)
        )
    }


}

@Composable
fun PokeDataItem(
    dataValue: Float,
    dataUnit: String,
    dataIcon: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(painter = dataIcon, "peso", modifier, tint = MaterialTheme.colors.onSurface)
        Spacer(Modifier.height(8.dp))
        Text(
            text = "$dataValue $dataUnit",
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
fun PokeStat(
    statName: String,
    statValue: Int,
    statMaxValue: Int,
    statColor: Color,
    height: Dp = 28.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
) {
    var animationPlayed by remember{
        mutableStateOf(false)
    }
    val currenPercentaje = animateFloatAsState(
        targetValue = if (animationPlayed){
            statValue/statMaxValue.toFloat()
        }else 0f,
        animationSpec = tween(
            animDuration,
            animDelay
        )
    )
    LaunchedEffect(key1=true){
        animationPlayed = true
    }
    Box(modifier=Modifier
        .fillMaxSize()
        .height(height)
        .clip(CircleShape)
        .background(
            if(isSystemInDarkTheme()){
                Color(0XFF505050)
            }else{
                Color.LightGray
            }
        )
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(currenPercentaje.value)
                .clip(CircleShape)
                .background(statColor)
                .padding(horizontal = 8.dp)
        ){

            Text(
                text = statName,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = (currenPercentaje.value *statMaxValue).toInt().toString(),
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@Composable
fun PokeBaseStat(
    pokeInfo: Pokemon,
    animDelayPerItem:Int = 100,

){
    val maxBaseStat = remember {
        pokeInfo.stats.maxOf {it.baseStat}
    }
    Column(
        modifier= Modifier.fillMaxWidth()
    ) {
        for (i in pokeInfo.stats.indices){
            val stat = pokeInfo.stats[i]
            PokeStat(
                parseStatToAbbr(stat),
                stat.baseStat,
                maxBaseStat,
                parseStatToColor(stat),
                animDelay = i * animDelayPerItem

            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}



/*
//            val painter = rememberImagePainter(
//            //  data = pokeInfo.sprites.frontDefault
//            data = pokeInfo.sprites.other.dreamWorld
//            )
//
//            Image(
//                painter = painter, contentDescription = "pokename",
//                modifier = Modifier.size(50.dp).padding(top = topPadding)
//            )

 */
