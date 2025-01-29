package com.mouredev.contador.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Se declara el uiState que es un envoltorio de ContadorState
 *
 * Created by Your name on 08/02/2024.
 */
class ContadorViewModel : ViewModel(){

    //Tenemos un uiState privado que si podemos modificar
    private var _contador = MutableStateFlow(0)
    //Tenemos una copia de _uisState publica que no podemos modificar
    val contador: StateFlow<Int> = _contador.asStateFlow()

    /**
     * Funcion que actualiza el uiState
     */
    fun actualizarValor(incrementoDecremento : Int) {
        _contador.value = _contador.value + incrementoDecremento
    }
}