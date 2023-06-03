package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository

class GetLocationsUseCase(private val repo: CharacterRepository) {

    fun getLocations() = repo.getLocations()

}