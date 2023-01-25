package com.geektech.rickandmorty.domain.model

data class CharacterDomain(
    val id: Int = DEFAULT_ID,
    val infoDomain: InfoDomain,
    val resultDomains: List<ResultDomain>
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}