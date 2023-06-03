package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.CharacterRepository

class GetEpisodesUseCase(private val repo: CharacterRepository) {

    fun getEpisodes() = repo.getEpisodes()

}