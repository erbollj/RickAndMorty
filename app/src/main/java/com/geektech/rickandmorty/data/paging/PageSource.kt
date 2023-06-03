package com.geektech.rickandmorty.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.geektech.rickandmorty.core.resultListToResultDomainList
import com.geektech.rickandmorty.data.network.ApiService
import com.geektech.rickandmorty.domain.model.CharacterResultDomain
import retrofit2.HttpException

class PageSource(
    private val api: ApiService
): PagingSource<Int, CharacterResultDomain>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterResultDomain>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterResultDomain> {
        val page: Int = params.key ?: 1
        val response = api.getPagedCharacters(page)
        val data = response.body()?.results?.resultListToResultDomainList() ?: emptyList()

        if (response.isSuccessful) {
            val nextKey = page + 1
            val prevKey = if (page == 1) null else page - 1
            return LoadResult.Page(data, prevKey = prevKey, nextKey = nextKey)
        } else {
            return LoadResult.Error(HttpException(response))
        }

    }

}