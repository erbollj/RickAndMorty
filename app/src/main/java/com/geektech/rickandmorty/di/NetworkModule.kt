package com.geektech.rickandmorty.di

import com.geektech.rickandmorty.data.network.CharactersApi
import com.geektech.rickandmorty.data.network.EpisodesApi
import com.geektech.rickandmorty.data.network.LocationsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createOkHttpClient() }
    single { provideCharactersApi(get()) }
    single { provideEpisodesApi(get()) }
    single { provideLocationsApi(get()) }
}

fun provideEpisodesApi(okHttpClient: OkHttpClient): EpisodesApi {

    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(EpisodesApi::class.java)

}

fun provideCharactersApi(okHttpClient: OkHttpClient): CharactersApi {

    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CharactersApi::class.java)

}

fun provideLocationsApi(okHttpClient: OkHttpClient): LocationsApi {

    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(LocationsApi::class.java)

}

fun createOkHttpClient(): OkHttpClient {

    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .build()

}
