package com.mouredev.contador


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mouredev.contador.ui.theme.ContadorTheme
import java.text.NumberFormat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContadorTheme {
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier.fillMaxSize(), contentAlignment =  Alignment.Center) {
                    AppContador()
                }
            }
        }
    }
}


/**
 * AppContador invoca a 2 funciones: BotonesContador y TextosContador
 *
 * En ambos necesitamos la variable valorActual, es por ello que "elevamos"
 * esta variable a la funcion padre de las 2: AppContador.
 *
 * De esta manera todos las funciones hija, tendrá acceso a esta variable
 * 
 */
@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContador() {
    var valorActual by remember { mutableStateOf(value = 0) }
    Column() {
        BotonesContador(

            presiona = { incremento -> valorActual += incremento }
            //presiona = { valorActual += it }

        )
        TextosContador(valorActual)
    }
}

/**
 * Recibo una funcion presion que tiene como argumento un entero y no devuelve nada.
 * Esa funcion será invocada al hacer click en el botón con el valor 1 si se suma y -1 si se resta
 * En ningún  caso podria recibir el parámetro valorActual en esta funcion para modificarlo, ya que
 * en Kotlin no son modificables los parámetros de una función:
 * https://stackoverflow.com/questions/44109098/how-do-i-make-method-param-mutable-in-kotlin
 *
 * Es por ello que se utiliza esta estrategia de pasar una funcion lambda
 *
 */
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

/**
 * Como en esta funcion no es necesario modificar valorActual,
 * podemos recibirlo como argumento.
 *
 */
@Composable
fun TextosContador(valorActual: Int) {
    Text(text = "$valorActual", fontSize = 30.sp)
    if (valorActual >100) {
        Text(text = "Valor límite alcanzado. No dejar entrar más gente", fontSize = 10.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorPreview() {
    ContadorTheme {
        AppContador()
    }
}