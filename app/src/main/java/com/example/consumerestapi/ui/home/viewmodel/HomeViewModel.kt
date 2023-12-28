package com.example.consumerestapi.ui.home.viewmodel

import com.example.consumerestapi.model.Kontak

sealed class KontakUIState {
    data class Success(val kontak: List<Kontak>) : KontakUIState()
    object Error : KontakUIState()
    object Loading : KontakUIState()
}