package com.mouredev.contador


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mouredev.contador.ui.theme.ContadorTheme
import com.mouredev.contador.vm.ContadorViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ContadorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContadorTheme {
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier.fillMaxSize(), contentAlignment =  Alignment.Center) {
                    AppContador(viewModel)
                }
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContador(viewModel: ContadorViewModel) {
    //Obtenemos contadorState, para asi pasarselo a textosContador
    val contador by viewModel.contador.collectAsState()
    Column() {
        BotonesContador(
            //Llamamos al viewModelo, que actualizara ContadorState y como consecuencia
            // se lanzara un recompose
            presiona = { viewModel.actualizarValor(it) }
        )
        TextosContador(contador)
    }
}

@Composable
fun BotonesContador(presiona: (Int)->Unit) {
    Column() {
        Button(onClick = { presiona(1) }) {
            Text(text = "SUMAR 1")
        }
        Button(onClick = { presiona(-1) }) {
            Text(text = "RESTAR 1")
        }
    }
}


@Composable
fun TextosContador(valorActual: Int) {
    Text(text = "$valorActual", fontSize = 30.sp)
    if (valorActual >100) {
        Text(text = "Valor límite alcanzado. No dejar entrar más gente", fontSize = 10.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun AppContadorPreview() {
    val previewViewModel = ContadorViewModel()
    ContadorTheme {
        AppContador(previewViewModel)
    }
}