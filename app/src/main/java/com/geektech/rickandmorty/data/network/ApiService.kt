package com.geektech.rickandmorty.data.network

import com.geektech.rickandmorty.data.model.Character
import com.geektech.rickandmorty.data.model.Episode
import com.geektech.rickandmorty.data.model.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/character")
    suspend fun getPagedCharacters(
        @Query("page") page: Int,
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("gender") gender: String?
    ): Response<Character>

    @GET("api/location")
    suspend fun getPagedLocations(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): Response<Location>

    @GET("api/episode")
    suspend fun getPagedEpisodes(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): Response<Episode>

}