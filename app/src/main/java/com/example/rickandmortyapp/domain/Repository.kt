package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.domain.model.RickAndMortyDetailModel
import com.example.rickandmortyapp.domain.model.RickAndMortyModel

interface Repository {

    suspend fun getCharacters(): RickAndMortyModel?

    suspend fun getCharacterDetail(id: Int): RickAndMortyDetailModel?
}