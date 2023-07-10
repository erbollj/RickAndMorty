package com.geektech.rickandmorty.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.geektech.rickandmorty.data.network.CharactersApi
import com.geektech.rickandmorty.data.paging.CharactersPagingSource
import com.geektech.rickandmorty.domain.model.CharacterResultDomain
import com.geektech.rickandmorty.domain.repo.CharactersRepository
import kotlinx.coroutines.flow.Flow

class CharactersRepositoryImpl(
    private val api: CharactersApi
) : CharactersRepository {

    override fun getPagedCharacters(
        name: String?,
        status: String?,
        gender: String?
    ): Flow<PagingData<CharacterResultDomain>> {
        return Pager(PagingConfig(10),
            pagingSourceFactory = {
                CharactersPagingSource(api, name, status, gender)
            }).flow
    }
}