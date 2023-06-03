package com.geektech.rickandmorty.di

import com.geektech.rickandmorty.domain.use_cases.GetPagedCharactersUseCase
import com.geektech.rickandmorty.domain.use_cases.GetPagedEpisodesUseCase
import com.geektech.rickandmorty.domain.use_cases.GetPagedLocationsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPagedLocationsUseCase(get()) }
    factory { GetPagedEpisodesUseCase(get()) }
    factory { GetPagedCharactersUseCase(get()) }
}