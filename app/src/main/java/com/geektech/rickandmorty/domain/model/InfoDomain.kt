package com.geektech.rickandmorty.domain.model

data class InfoDomain(
    val count: Int,
    val next: String? = null,
    val pages: Int,
    val prev: String? = null
)