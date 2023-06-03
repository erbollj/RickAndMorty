package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository

class GetPagedCharactersUseCase(private val repo: CharacterRepository){
    fun getPagedCharacters() = repo.getPagedCharacters()
}