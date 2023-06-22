package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.Repository

class GetPagedLocationsUseCase(private val repo: Repository) {
    fun getPagedLocations(name: String?) = repo.getPagedLocations(name)

}