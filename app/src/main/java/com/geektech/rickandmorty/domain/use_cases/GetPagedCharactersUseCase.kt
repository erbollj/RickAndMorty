package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.Repository

class GetPagedCharactersUseCase(private val repo: Repository) {
    fun getPagedCharacters(name: String?, status: String?, gender: String?) =
        repo.getPagedCharacters(name, status, gender)

}