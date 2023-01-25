package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.model.CharacterDomain
import com.geektech.rickandmorty.domain.repo.CharacterRepository
import javax.inject.Inject

class AddCharacterUseCase @Inject constructor (private val repo: CharacterRepository) {

    fun addCharacter(characterDomain: CharacterDomain?) = repo.addCharacter(characterDomain)

}