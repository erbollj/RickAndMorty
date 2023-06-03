package com.geektech.rickandmorty.data.model

data class Info(
    val count: Int,
    val next: String? = null,
    val pages: Int,
    val prev: String? = null
)