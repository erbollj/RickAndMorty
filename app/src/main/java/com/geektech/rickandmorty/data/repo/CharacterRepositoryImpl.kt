package com.geektech.rickandmorty.data.repo

import android.util.Log
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.*
import com.geektech.rickandmorty.core.*
import com.geektech.rickandmorty.data.network.ApiService
import com.geektech.rickandmorty.data.paging.EpisodePagingSource
import com.geektech.rickandmorty.data.paging.LocationPagingSource
import com.geektech.rickandmorty.data.paging.PageSource
import com.geektech.rickandmorty.domain.model.*
import com.geektech.rickandmorty.domain.repo.CharacterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.coroutineContext

class CharacterRepositoryImpl(
    private val api: ApiService,
) : CharacterRepository {

    override fun getCharacters(): Flow<Resource<CharacterDomain>> =
        flow {
            emit(Resource.Loading())
            val result = api.getCharacters()
            if (result.isSuccessful) {
                Log.e("ololo", "getCharacters: " + result.body())
                emit(Resource.Success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.Error(result.message()))
                Log.e("ololo", "getCharacters: " + result.code())
            }
        }

    override fun getPagedCharacters(): Flow<PagingData<CharacterResultDomain>> {
        return Pager(PagingConfig(10),
            pagingSourceFactory = {
                PageSource(api)
            }
        ).flow
    }

    override fun getLocations(): Flow<Resource<LocationDomain>> =
        flow {
            emit(Resource.Loading())
            val result = api.getLocations()
            if (result.isSuccessful) {
                Log.e("ololo", "getLocations: " + result.body())
                emit(Resource.Success(result.body()!!.locationToLocationDomain()))
            } else {
                emit(Resource.Error(result.message()))
            }
        }

    override fun getPagedLocations(): Flow<PagingData<LocationResultDomain>> {
        return Pager(PagingConfig(10), pagingSourceFactory = {
            LocationPagingSource(api)
        }).flow
    }

    override fun getEpisodes(): Flow<Resource<EpisodeDomain>> =
        flow {
            emit(Resource.Loading())
            val result = api.getEpisodes()
            if (result.isSuccessful) {
                Log.e("ololo", "getEpisodes: " + result.body())
                emit(Resource.Success(result.body()!!.episodeToEpisodeDomain()))
            } else {
                emit(Resource.Error(result.message()))
            }
        }

    override fun getPagedEpisodes(): Flow<PagingData<EpisodeResultDomain>> {
        return Pager(PagingConfig(10), pagingSourceFactory = {
            EpisodePagingSource(api)
        } ).flow
    }

    override fun getCharactersByStatusAndGender(
        status: String,
        gender: String
    ): Flow<Resource<CharacterDomain>> = flow {
        emit(Resource.Loading())
        val result = api.getCharactersByStatusAndGender(status, gender)
        if (result.isSuccessful) {
            emit(Resource.Success(result.body()!!.characterToCharacterDomain()))
        } else {
            emit(Resource.Error(result.message()))
        }
    }

    override fun getCharactersByStatus(status: String): Flow<Resource<CharacterDomain>> =
        flow {
            emit(Resource.Loading())
            val result = api.getCharactersByStatus(status)
            if (result.isSuccessful) {
                emit(Resource.Success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.Error(result.message()))
            }
        }

    override fun getCharactersByGender(gender: String): Flow<Resource<CharacterDomain>> =
        flow {
            emit(Resource.Loading())
            val result = api.getCharactersByGender(gender)
            if (result.isSuccessful) {
                emit(Resource.Success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.Error(result.message()))
            }
        }

    override fun getCharacterByName(name: String): Flow<Resource<CharacterDomain>> =
        flow {
            emit(Resource.Loading())
            val result = api.getCharactersByName(name)
            if (result.isSuccessful) {
                emit(Resource.Success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.Error(result.message()))
            }
        }

}