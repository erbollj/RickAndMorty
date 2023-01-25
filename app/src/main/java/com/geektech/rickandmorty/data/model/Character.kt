package com.geektech.rickandmorty.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val info: Info,
    val results: List<Result>
)