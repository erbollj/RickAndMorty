package com.geektech.rickandmorty.domain.model

data class InfoDomain(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any? = null
)