package com.geektech.rickandmorty.domain.model

data class CharacterDomain(
    val infoDomain: InfoDomain,
    val resultsDomain: List<CharacterResultDomain>,
)