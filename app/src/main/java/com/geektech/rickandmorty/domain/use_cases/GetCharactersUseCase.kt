package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repo: CharacterRepository) {

    fun getCharacters(page: Int) = repo.getCharacters(page)

}