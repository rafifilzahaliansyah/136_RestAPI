package com.example.consumerestapi.repository

import com.example.consumerestapi.model.Kontak
import com.example.consumerestapi.network.KontakService
import java.io.IOException

interface KontakRepository {
    /** Fetches list of Kontak from kontakApi */
    suspend fun getKontak(): List<Kontak>

    suspend fun insertkontak(kontak: Kontak)

    suspend fun updatekontak(id: Int, kontak: Kontak)

    suspend fun deletekontak(id: Int)

    suspend fun getkontakById(id: Int): Kontak
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    /** Fetches list of Kontak from kontakApi */
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()

    override suspend fun insertkontak(kontak: Kontak) {
        kontakApiService.insertKontak(kontak)
    }

    override suspend fun updatekontak(id: Int, kontak: Kontak) {
        kontakApiService.updateKontak(id, kontak)
    }

    override suspend fun deletekontak(id: Int) {
        try {
            val response = kontakApiService.deleteKontak(id)
            if (!response.isSuccessful) {
                throw IOException(
                    "Failed to delete kontak. HTTP status code:" +
                            " ${response.code()}"
                )
            } else {
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getkontakById(id: Int): Kontak {
        return kontakApiService.getKontakById(id)
    }

}
