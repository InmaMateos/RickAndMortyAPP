package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.network.response.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApiService {

    @GET("character")
    suspend fun getCharacters(): Response<RickAndMortyResponse>
}