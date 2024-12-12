package com.colecciono.micoleccion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.colecciono.micoleccion.ui.theme.MiColeccionTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiColeccionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ViewContainer(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewContainer(modifier: Modifier){
    Scaffold(
        topBar = { ToolBar()},
        content = { innerPadding ->
            Contenido(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar(){
    TopAppBar(title = {Text(text = "Mi colección")},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.black), // Fondo negro
            titleContentColor = Color.White                    // Texto blanco
        )
    )
}

@NoLiveLiterals
@Composable
fun Contenido(modifier: Modifier){
    val nombres: List<String> = listOf("Draculaura core", "Draculaura core refresh", "Abbey Bominable core", "Frankie Stein core", "Clawdeen core", "Cleo Faboolous Pets", "Twyla Fearbook")
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        // Texto antes de la lista
        Text(
            text = "Abajo hay una lista de muñecas con diferentes nombres que tienen un botón para marcar cuales tienes y cuales no.",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .align(Alignment.Start)
        )
        LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
            items(items = nombres) { nombre ->
                Objeto(nombre = nombre)
            }
        }
    }

}

@Composable
fun Objeto(nombre: String, modifier: Modifier = Modifier) {
    var adquirida by rememberSaveable { mutableStateOf(false)}
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 8.dp, horizontal = 15.dp)
    ) {
        Row(modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically, // Centra los elementos verticalmente
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.size(80.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.draculauracorerefresh), // Reemplaza con tu imagen
                    contentDescription = "Imagen de objeto",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(modifier = Modifier
                .weight(1f)
                .padding(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(nombre)
                ElevatedButton(
                    onClick = { adquirida = !adquirida },
                ) {
                    Text(if (adquirida) "La tienes!" else "Por conseguir")
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MiColeccionTheme {
//        Contenido(modifier = Modifier.padding(40.dp))
//    }
//}

@Preview
@Composable
fun ContenidoPreview() {
    ViewContainer(Modifier.fillMaxSize())
}