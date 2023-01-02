package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository
import javax.inject.Inject

class GetCharacterByNameUseCase @Inject constructor(private val repo: CharacterRepository) {

    fun getCharacterByName(name: String) = repo.getCharacterByName(name)

}