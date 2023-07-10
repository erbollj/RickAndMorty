package com.geektech.rickandmorty.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.geektech.rickandmorty.data.network.LocationsApi
import com.geektech.rickandmorty.data.paging.LocationsPagingSource
import com.geektech.rickandmorty.domain.model.LocationResultDomain
import com.geektech.rickandmorty.domain.repo.LocationsRepository
import kotlinx.coroutines.flow.Flow

class LocationsRepositoryImpl(
    private val api: LocationsApi
) : LocationsRepository {
    override fun getPagedLocations(name: String?): Flow<PagingData<LocationResultDomain>> {
        return Pager(PagingConfig(10), pagingSourceFactory = {
            LocationsPagingSource(api, name)
        }).flow
    }
}