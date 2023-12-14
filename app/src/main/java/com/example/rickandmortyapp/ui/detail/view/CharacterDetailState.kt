package com.example.rickandmortyapp.ui.detail.view

import com.example.rickandmortyapp.domain.model.RickAndMortyDetailModel

sealed class CharacterDetailState{


    data object Loading: CharacterDetailState()

    data class Error(val message: String): CharacterDetailState()

    data class Success(
        val characterId: Int,
        val name: String,
        val status: String,
        val species: String,
        val type: String,
        val image: String,
        val rickAndMortyDetailModel: RickAndMortyDetailModel): CharacterDetailState()
}
