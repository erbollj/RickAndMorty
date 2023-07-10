package com.geektech.rickandmorty.domain.repo

import androidx.paging.PagingData
import com.geektech.rickandmorty.domain.model.EpisodeResultDomain
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {

    fun getPagedEpisodes(name: String?): Flow<PagingData<EpisodeResultDomain>>

}