package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository
import javax.inject.Inject

class GetCharactersByGenderUseCase @Inject constructor(private val repo: CharacterRepository) {

    fun getCharactersByGender(gender: String) = repo.getCharactersByGender(gender)

}