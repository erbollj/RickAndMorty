package com.geektech.rickandmorty.data.model

import android.os.Parcelable
import com.geektech.rickandmorty.domain.model.Location
import com.geektech.rickandmorty.domain.model.Origin
import kotlinx.android.parcel.Parcelize

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)