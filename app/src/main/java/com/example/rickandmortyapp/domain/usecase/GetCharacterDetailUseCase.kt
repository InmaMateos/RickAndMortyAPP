package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.domain.Repository
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke(id: Int) = repository.getCharacterDetail(id)
}