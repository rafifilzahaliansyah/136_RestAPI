package com.example.consumerestapi.ui

import android.text.Spannable.Factory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.consumerestapi.KontakApplication
import com.example.consumerestapi.reposirory.KontakContainer
import com.example.consumerestapi.ui.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            MarsViewModel(aplikasiMars().Container.marsPhotoRepository)
        }
        initializer {
            HomeViewModel(aplikasiMars().container.kontakRepository)
        }
    }
}

fun CreationExtras.aplikasiMars(): KontakApplication =
    (this[viewModelProvider.Android.ViewModelFactory.APPLICATION_kEY] as KontakContainer)