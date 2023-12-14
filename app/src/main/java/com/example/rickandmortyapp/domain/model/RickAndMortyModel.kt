package com.example.rickandmortyapp.domain.model

import com.example.rickandmortyapp.data.network.response.Info
import com.example.rickandmortyapp.data.network.response.Result



data class RickAndMortyModel(
    val info : Info,
    val characters : List<Result>
)
