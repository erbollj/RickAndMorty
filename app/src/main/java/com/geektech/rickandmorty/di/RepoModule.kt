package com.geektech.rickandmorty.di

import com.geektech.rickandmorty.data.network.ApiService
import com.geektech.rickandmorty.data.repo.RepositoryImpl
import com.geektech.rickandmorty.domain.repo.Repository
import org.koin.dsl.module

val repoModule = module {
    single { provideRepo(get()) }
}

fun provideRepo(api: ApiService): Repository {
    return RepositoryImpl(api)
}
