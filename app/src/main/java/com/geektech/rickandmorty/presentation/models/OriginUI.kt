package com.geektech.rickandmorty.presentation.models

import kotlinx.serialization.Serializable

@Serializable
data class OriginUI(
    val name: String,
    val url: String
) : java.io.Serializable