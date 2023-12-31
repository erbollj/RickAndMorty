package com.geektech.rickandmorty.domain.model


data class CharacterResultDomain(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val locationDomain: CharacterLocationDomain,
    val name: String,
    val originDomain: OriginDomain,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)