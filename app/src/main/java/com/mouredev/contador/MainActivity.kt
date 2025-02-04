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


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContador() {
    var valorActual by remember { mutableStateOf(value = 0) }
    Column() {
        Button(onClick = { valorActual += 1 }) {
            Text(text = "SUMAR 1")
        }
        Button(onClick = { valorActual -= 1 }) {
            Text(text = "RESTAR 1")
        }
        TextosContador(valorActual)
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
fun ContadorPreview() {
    ContadorTheme {
        AppContador()
    }
}