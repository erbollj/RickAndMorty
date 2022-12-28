package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository

class GetCharactersByStatusUseCase(private val repo: CharacterRepository) {

    fun getCharactersByStatus(status: String) = repo.getCharactersByStatus(status)

}