package com.geektech.rickandmorty.di

import com.geektech.rickandmorty.data.network.ApiService
import com.geektech.rickandmorty.data.repo.CharacterRepositoryImpl
import com.geektech.rickandmorty.domain.repo.CharacterRepository
import org.koin.dsl.module

val repoModule = module {
    single { provideRepo(get()) }
}

fun provideRepo(api: ApiService): CharacterRepository {
    return CharacterRepositoryImpl(api)
}
