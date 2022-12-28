package com.geektech.rickandmorty

import android.app.Application
import com.geektech.rickandmorty.data.repo.CharacterRepositoryImpl
import com.geektech.rickandmorty.domain.repo.CharacterRepository

class App: Application() {
    fun initialize() : CharacterRepository {
        return CharacterRepositoryImpl()
    }
    init {
        initialize()
    }
}