package com.example.consumerestapi

import android.app.Application
import com.example.consumerestapi.reposirory.AppContainer
import com.example.consumerestapi.reposirory.KontakContainer

class KontakApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}