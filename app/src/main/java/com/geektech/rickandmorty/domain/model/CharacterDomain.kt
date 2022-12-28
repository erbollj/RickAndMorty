package com.geektech.rickandmorty.domain.model

data class CharacterDomain(
    val info: Info,
    val results: List<Result>
)