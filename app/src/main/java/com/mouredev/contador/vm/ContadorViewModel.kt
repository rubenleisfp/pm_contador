package com.mouredev.contador.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContadorViewModel : ViewModel(){

    //Esta variable es de lectura y escritura, pero solo la puedo modificar en mi viewModel
    private var _contador = MutableStateFlow(0)
    //Esto es una copia de mi variable _contador, de solo lectura
    val contador : StateFlow<Int> = _contador.asStateFlow()


    fun actualizarValor(incremento: Int) {
        Log.i("ContadorViewModel", "El usuario ha actualizado el valor con este incremento : $incremento")
        _contador.value = _contador.value + incremento
    }
}