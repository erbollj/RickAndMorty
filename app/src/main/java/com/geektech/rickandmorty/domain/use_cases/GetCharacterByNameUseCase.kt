package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository

class GetCharacterByNameUseCase(private val repo: CharacterRepository) {

    fun getCharacterByName(name: String) = repo.getCharacterByName(name)

}