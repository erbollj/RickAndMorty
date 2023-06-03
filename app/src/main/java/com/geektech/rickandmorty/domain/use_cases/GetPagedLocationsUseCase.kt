package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository

class GetPagedLocationsUseCase(private val repo: CharacterRepository) {
    fun getPagedLocations() = repo.getPagedLocations()
}