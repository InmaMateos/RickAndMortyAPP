package com.example.rickandmortyapp.ui.List.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.network.response.Result

import com.example.rickandmortyapp.domain.usecase.GetCharacterListUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(private val getCharacterListUseCase: GetCharacterListUseCase): ViewModel() {

    private var _characters = MutableStateFlow<List<Result>>(emptyList())

    val characters:StateFlow<List<Result>> = _characters

    fun getCharacters(){
        viewModelScope.launch {
            val characterList = getCharacterListUseCase()
            if (characterList != null) {
                withContext(Dispatchers.Main) {
                    _characters.value = characterList.characters
                }
            }
        }
    }
}