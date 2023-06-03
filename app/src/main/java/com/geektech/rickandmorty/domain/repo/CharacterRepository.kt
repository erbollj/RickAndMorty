package com.geektech.rickandmorty.domain.repo

import androidx.paging.PagingData
import com.geektech.rickandmorty.core.Resource
import com.geektech.rickandmorty.domain.model.*
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters(): Flow<Resource<CharacterDomain>>

    fun getPagedCharacters(): Flow<PagingData<CharacterResultDomain>>

    fun getCharactersByStatusAndGender(status: String, gender: String): Flow<Resource<CharacterDomain>>

    fun getCharactersByStatus(status: String): Flow<Resource<CharacterDomain>>

    fun getCharactersByGender(gender: String): Flow<Resource<CharacterDomain>>

    fun getCharacterByName(name: String): Flow<Resource<CharacterDomain>>

    fun getLocations(): Flow<Resource<LocationDomain>>

    fun getPagedLocations(): Flow<PagingData<LocationResultDomain>>

    fun getEpisodes(): Flow<Resource<EpisodeDomain>>

    fun getPagedEpisodes(): Flow<PagingData<EpisodeResultDomain>>

}