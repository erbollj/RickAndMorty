package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.EpisodesRepository

class GetPagedEpisodesUseCase(private val repo: EpisodesRepository) {
    fun getPagedEpisodes(name: String?) = repo.getPagedEpisodes(name)

}