package com.geektech.rickandmorty.di

import com.geektech.rickandmorty.data.network.CharactersApi
import com.geektech.rickandmorty.data.network.EpisodesApi
import com.geektech.rickandmorty.data.network.LocationsApi
import com.geektech.rickandmorty.data.repo.CharactersRepositoryImpl
import com.geektech.rickandmorty.data.repo.EpisodesRepositoryImpl
import com.geektech.rickandmorty.data.repo.LocationsRepositoryImpl
import com.geektech.rickandmorty.domain.repo.CharactersRepository
import com.geektech.rickandmorty.domain.repo.EpisodesRepository
import com.geektech.rickandmorty.domain.repo.LocationsRepository
import org.koin.dsl.module

val repoModule = module {
    single { provideCharactersRepo(get()) }
    single { provideEpisodesRepo(get()) }
    single { provideLocationsRepo(get()) }
}

fun provideLocationsRepo(api: LocationsApi): LocationsRepository {
    return LocationsRepositoryImpl(api)
}

fun provideCharactersRepo(api: CharactersApi): CharactersRepository {
    return CharactersRepositoryImpl(api)
}

fun provideEpisodesRepo(api: EpisodesApi): EpisodesRepository {
    return EpisodesRepositoryImpl(api)
}
