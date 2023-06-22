package com.geektech.rickandmorty.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.geektech.rickandmorty.core.episodeResultToEpisodeResultDomain
import com.geektech.rickandmorty.data.network.ApiService
import com.geektech.rickandmorty.domain.model.EpisodeResultDomain
import retrofit2.HttpException

class EpisodesPagingSource(private val api: ApiService, private val name: String?) :
    PagingSource<Int, EpisodeResultDomain>() {

    override fun getRefreshKey(state: PagingState<Int, EpisodeResultDomain>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.minus(1) ?: return page.nextKey?.plus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeResultDomain> {
        val page = params.key ?: 1
        val response = api.getPagedEpisodes(page, name)
        val data = response.body()?.results?.episodeResultToEpisodeResultDomain() ?: emptyList()

        return if (response.isSuccessful) {
            val nextKey = page + 1
            val prevKey = if (page == 1) null else page - 1
            LoadResult.Page(prevKey = prevKey, nextKey = nextKey, data = data)
        } else {
            LoadResult.Error(HttpException(response))
        }
    }

}