package com.example.rickandmortyapp.network.response

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(
    @SerializedName ("info") val info: Info,
    @SerializedName ("results") val characters: List<Result>
)