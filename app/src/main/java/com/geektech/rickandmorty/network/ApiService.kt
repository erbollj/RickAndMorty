package com.geektech.rickandmorty.network

import com.geektech.rickandmorty.model.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/character")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): Response<Character>

    @GET("api/character")
    suspend fun getCharactersByStatusAndGender(
        @Query("status") status: String,
        @Query("gender") gender: String
    ): Response<Character>

    @GET("api/character")
    suspend fun getCharactersByStatus(
        @Query("status") status: String
    ): Response<Character>

    @GET("api/character")
    suspend fun getCharactersByGender(
        @Query("gender") gender: String
    ): Response<Character>

}