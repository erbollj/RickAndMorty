package com.geektech.rickandmorty.domain.model

data class LocationDomain (
    val info: InfoDomain,
    val results: List<LocationResultDomain>
)

