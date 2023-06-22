package com.geektech.rickandmorty.domain.use_cases

import com.geektech.rickandmorty.domain.repo.Repository

class GetPagedEpisodesUseCase(private val repo: Repository) {
    fun getPagedEpisodes(name: String?) = repo.getPagedEpisodes(name)

}