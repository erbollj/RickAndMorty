package com.geektech.rickandmorty.data.network

import com.geektech.rickandmorty.data.model.EpisodeDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodesApi {

    @GET("api/episode")
    suspend fun getPagedEpisodes(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): Response<EpisodeDto>

}