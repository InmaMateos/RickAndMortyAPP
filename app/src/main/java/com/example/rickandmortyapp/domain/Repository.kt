package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.domain.model.RickAndMortyModel

interface Repository {

    suspend fun getCharacters(): RickAndMortyModel?
}