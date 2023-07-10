package com.geektech.rickandmorty.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.geektech.rickandmorty.data.network.EpisodesApi
import com.geektech.rickandmorty.data.paging.EpisodesPagingSource
import com.geektech.rickandmorty.domain.model.EpisodeResultDomain
import com.geektech.rickandmorty.domain.repo.EpisodesRepository
import kotlinx.coroutines.flow.Flow

class EpisodesRepositoryImpl(
    private val api: EpisodesApi
) : EpisodesRepository {
    override fun getPagedEpisodes(name: String?): Flow<PagingData<EpisodeResultDomain>> {
        return Pager(PagingConfig(10),
            pagingSourceFactory = {
                EpisodesPagingSource(api, name)
            }).flow
    }
}