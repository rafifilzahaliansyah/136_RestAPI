package com.example.consumerestapi.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumerestapi.model.Kontak
import com.example.consumerestapi.repository.KontakRepository
import com.example.consumerestapi.repository.NetworkKontakRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed class KontakUiState {
    data class Success(val kontak: List<Kontak>) : KontakUiState()
    object Error : KontakUiState()
    object Loading : KontakUiState()
}

class HomeViewModel(private val kontakRepository: KontakRepository) : ViewModel() {
    var kontakUiState: KontakUiState by mutableStateOf(KontakUiState.Loading)
        private set

    init {
        getKontak()
    }

    fun getKontak() {
        viewModelScope.launch {
            kontakUiState = KontakUiState.Loading
            kontakUiState = try {
                KontakUiState.Success(kontakRepository.getKontak())
            } catch (e: IOException) {
                KontakUiState.Error
            } catch (e: HttpException) {
                KontakUiState.Error
            }
        }
    }
}