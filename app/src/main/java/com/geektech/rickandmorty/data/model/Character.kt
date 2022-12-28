package com.geektech.rickandmorty.data.model

import com.geektech.rickandmorty.domain.model.Info
import com.geektech.rickandmorty.domain.model.Result

data class Character(
    val info: Info,
    val results: List<Result>
)