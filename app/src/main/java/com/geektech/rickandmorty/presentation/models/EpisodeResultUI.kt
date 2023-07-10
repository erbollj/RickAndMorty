package com.geektech.rickandmorty.presentation.models

data class EpisodeResultUI(
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)