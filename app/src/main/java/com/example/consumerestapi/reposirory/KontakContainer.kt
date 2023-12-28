package com.example.consumerestapi.reposirory

import com.example.consumerestapi.network.KontakService
import com.example.consumerestapi.repository.KontakRepository
import com.example.consumerestapi.repository.NetworkKontakRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val kontakRepository: KontakRepository
}

class KontakContainer : AppContainer {
    private val  baseUrl = "https://kancadonor.net//donorg/"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder().
    addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val KontakService:KontakService by lazy {
        retrofit.create(KontakService::class.java)
    }
    override val kontakRepository: KontakRepository by lazy {
        NetworkKontakRepository(KontakService)
    }
}