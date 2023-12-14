package com.example.rickandmortyapp.ui.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.domain.usecase.GetCharacterDetailUseCase
import com.example.rickandmortyapp.ui.detail.view.CharacterDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class CharacterDetailViewModel @Inject constructor(private val getCharacterDetailUseCase: GetCharacterDetailUseCase): ViewModel() {

    private var _state = MutableStateFlow<CharacterDetailState>(CharacterDetailState.Loading)
    val state: StateFlow<CharacterDetailState> = _state


    fun getCharacterDetail(characterID: Int){
        viewModelScope.launch {
            _state.value = CharacterDetailState.Loading
            val result = withContext(Dispatchers.IO){ getCharacterDetailUseCase(characterID) }

            if (result!=null){
                _state.value = CharacterDetailState.Success(result.id, result.name, result.status, result.species, result.type, result.image, result)
            }else{
                _state.value = CharacterDetailState.Error("Ha ocurrido un error")
            }

        }
    }
}