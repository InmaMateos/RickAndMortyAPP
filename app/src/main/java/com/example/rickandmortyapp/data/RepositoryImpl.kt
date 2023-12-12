package com.example.rickandmortyapp.data

import android.util.Log
import com.example.rickandmortyapp.data.network.RickAndMortyApiService
import com.example.rickandmortyapp.domain.Repository
import com.example.rickandmortyapp.domain.model.RickAndMortyModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: RickAndMortyApiService) : Repository {
    override suspend fun getCharacters(): RickAndMortyModel? {
        runCatching { apiService.getCharacters() }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Inma", "Ha ocurrido un error") }
        return null
    }
}