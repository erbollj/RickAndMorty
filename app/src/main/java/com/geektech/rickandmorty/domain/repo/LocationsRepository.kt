package com.geektech.rickandmorty.domain.repo

import androidx.paging.PagingData
import com.geektech.rickandmorty.domain.model.LocationResultDomain
import kotlinx.coroutines.flow.Flow

interface LocationsRepository {

    fun getPagedLocations(name: String?): Flow<PagingData<LocationResultDomain>>

}