package com.geektech.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class CharacterLocationDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)