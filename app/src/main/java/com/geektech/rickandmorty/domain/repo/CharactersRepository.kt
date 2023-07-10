package com.geektech.rickandmorty.domain.repo

import androidx.paging.PagingData
import com.geektech.rickandmorty.domain.model.CharacterResultDomain
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getPagedCharacters(
        name: String?,
        status: String?,
        gender: String?
    ): Flow<PagingData<CharacterResultDomain>>
}