package com.example.rickandmortyapp.domain.model

data class RickAndMortyDetailModel(
    var id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val image: String
)
