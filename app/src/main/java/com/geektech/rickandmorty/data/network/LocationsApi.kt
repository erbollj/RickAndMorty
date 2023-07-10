package com.geektech.rickandmorty.data.network

import com.geektech.rickandmorty.data.model.LocationDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationsApi {

    @GET("api/location")
    suspend fun getPagedLocations(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): Response<LocationDto>

}