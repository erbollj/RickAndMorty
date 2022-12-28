package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository

class GetCharactersByStatusAndGenderUseCase(private val repo: CharacterRepository) {

    fun getCharactersByStatusAndGender(status: String, gender: String)
    = repo.getCharactersByStatusAndGender(status, gender)

}