package com.geektech.rickandmorty.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Location(
    val name: String,
    val url: String
)