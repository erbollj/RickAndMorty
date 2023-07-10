package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.LocationsRepository

class GetPagedLocationsUseCase(private val repo: LocationsRepository) {
    fun getPagedLocations(name: String?) = repo.getPagedLocations(name)

}