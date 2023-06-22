package com.geektech.rickandmorty.data.repo

import androidx.paging.*
import com.geektech.rickandmorty.data.network.ApiService
import com.geektech.rickandmorty.data.paging.EpisodesPagingSource
import com.geektech.rickandmorty.data.paging.LocationsPagingSource
import com.geektech.rickandmorty.data.paging.CharactersPagingSource
import com.geektech.rickandmorty.domain.model.*
import com.geektech.rickandmorty.domain.repo.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val api: ApiService,
) : Repository {

    override fun getPagedCharacters(
        name: String?,
        status: String?,
        gender: String?
    ): Flow<PagingData<CharacterResultDomain>> {
        return Pager(PagingConfig(10),
            pagingSourceFactory = {
                CharactersPagingSource(api, name, status, gender)
            }
        ).flow
    }

    override fun getPagedLocations(name: String?): Flow<PagingData<LocationResultDomain>> {
        return Pager(PagingConfig(10), pagingSourceFactory = {
            LocationsPagingSource(api, name)
        }).flow
    }

    override fun getPagedEpisodes(name:String?): Flow<PagingData<EpisodeResultDomain>> {
        return Pager(PagingConfig(10), pagingSourceFactory = {
            EpisodesPagingSource(api, name)
        }).flow
    }

}