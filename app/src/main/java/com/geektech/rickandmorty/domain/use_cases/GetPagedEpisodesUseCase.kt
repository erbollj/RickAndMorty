package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository

class GetPagedEpisodesUseCase(private val repo: CharacterRepository) {
    fun getPagedEpisodes() = repo.getPagedEpisodes()
}