package com.geektech.rickandmorty.domain.model

data class EpisodeDomain(
    val info: InfoDomain,
    val results: List<EpisodeResultDomain>
)