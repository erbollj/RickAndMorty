package com.geektech.rickandmorty.presentation.models

import kotlinx.serialization.Serializable

@Serializable
data class CharacterLocationUI(
    val name: String,
    val url: String
) : java.io.Serializable