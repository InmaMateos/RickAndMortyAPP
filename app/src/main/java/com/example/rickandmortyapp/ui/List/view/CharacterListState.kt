package com.example.rickandmortyapp.ui.List.view

import com.example.rickandmortyapp.domain.model.RickAndMortyModel

sealed class CharacterListState{

    data object  Loading:CharacterListState()

    data class Error(val error:String):CharacterListState()

    data class Success(val rickAndMortyModel: RickAndMortyModel):CharacterListState()
}
