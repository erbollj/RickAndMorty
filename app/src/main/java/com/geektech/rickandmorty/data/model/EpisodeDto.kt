package com.geektech.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    @SerializedName("info")
    val info: InfoDto,
    @SerializedName("results")
    val results: List<EpisodeResultDto>
)
//Data - CharacterDto
//        Domain - CharacterModel
//        Presentation - CharacterUI