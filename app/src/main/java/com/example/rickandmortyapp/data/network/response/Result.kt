package com.example.rickandmortyapp.data.network.response

import com.example.rickandmortyapp.domain.model.RickAndMortyDetailModel
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("created") val created: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("location") val location: Location,
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: Origin,
    @SerializedName("species") val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
)
{
    fun toDomain(): RickAndMortyDetailModel? {
        return RickAndMortyDetailModel(
            id = id,
            name = name,
            status = status,
            species = species,
            type = type,
            image = image
        )
    }
}