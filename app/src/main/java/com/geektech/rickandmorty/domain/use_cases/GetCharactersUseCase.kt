package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository

class GetCharactersUseCase(private val repo: CharacterRepository) {

    fun getCharacters() = repo.getCharacters()

}