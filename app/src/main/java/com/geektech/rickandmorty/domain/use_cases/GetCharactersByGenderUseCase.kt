package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository

class GetCharactersByGenderUseCase(private val repo: CharacterRepository) {

    fun getCharactersByGender(gender: String) = repo.getCharactersByGender(gender)

}