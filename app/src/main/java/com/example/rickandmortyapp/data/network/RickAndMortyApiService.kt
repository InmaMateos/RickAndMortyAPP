package com.example.rickandmortyapp.data.network

import com.example.rickandmortyapp.data.network.response.Result
import com.example.rickandmortyapp.data.network.response.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApiService {

    @GET("character")
    suspend fun getCharacters(): RickAndMortyResponse

    @GET("character/{id}")
    suspend fun getCharacterDetail(@Path("id") id: Int): Result


}