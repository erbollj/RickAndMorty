package com.geektech.rickandmorty.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationDomain(
    val name: String,
    val url: String
) : Parcelable