package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharactersRepository

class GetPagedCharactersUseCase(private val repo: CharactersRepository) {
    fun getPagedCharacters(name: String?, status: String?, gender: String?) =
        repo.getPagedCharacters(name, status, gender)

}