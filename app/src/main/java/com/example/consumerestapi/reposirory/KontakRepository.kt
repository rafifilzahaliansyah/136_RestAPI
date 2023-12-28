package com.example.consumerestapi.repository

import com.example.consumerestapi.model.Kontak
import com.example.consumerestapi.network.KontakService

interface KontakRepository {
    /** Fetches list of kontak from kontakApi */
    suspend fun getKontak(): List<Kontak>
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    /** Fetches list of kontak from kontakApi */
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}