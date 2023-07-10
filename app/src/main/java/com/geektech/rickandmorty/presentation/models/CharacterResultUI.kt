package com.geektech.rickandmorty.presentation.models


import kotlinx.serialization.Serializable

@Serializable
data class CharacterResultUI(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val locationDomain: CharacterLocationUI,
    val name: String,
    val originDomain: OriginUI,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) : java.io.Serializable