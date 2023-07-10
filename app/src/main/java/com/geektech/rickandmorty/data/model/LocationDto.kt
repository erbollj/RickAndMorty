package com.geektech.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("info")
    val info: InfoDto,
    @SerializedName("results")
    val results: List<LocationResultDto>
)