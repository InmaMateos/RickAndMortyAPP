package com.example.rickandmortyapp.data.network.response

import com.example.rickandmortyapp.domain.model.RickAndMortyModel
import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(
    @SerializedName ("info") val info: Info,
    @SerializedName ("results") val characters: List<Result>
){
    fun toDomain(): RickAndMortyModel? {
        return RickAndMortyModel(
            info = info,
            characters = characters
        )
    }
}