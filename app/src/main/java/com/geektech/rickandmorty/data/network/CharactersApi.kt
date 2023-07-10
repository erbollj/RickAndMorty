package com.geektech.rickandmorty.data.network

import com.geektech.rickandmorty.data.model.CharacterDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET("api/character")
    suspend fun getPagedCharacters(
        @Query("page") page: Int,
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("gender") gender: String?
    ): Response<CharacterDto>

}