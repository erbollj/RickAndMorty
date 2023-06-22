package com.geektech.rickandmorty.domain.repo

import androidx.paging.PagingData
import com.geektech.rickandmorty.domain.model.*
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getPagedCharacters(
        name: String?,
        status: String?,
        gender: String?
    ): Flow<PagingData<CharacterResultDomain>>

    fun getPagedLocations(name: String?): Flow<PagingData<LocationResultDomain>>

    fun getPagedEpisodes(name: String?): Flow<PagingData<EpisodeResultDomain>>

}