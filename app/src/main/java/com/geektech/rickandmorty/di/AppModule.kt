package com.geektech.rickandmorty.di

import com.geektech.rickandmorty.data.network.ApiService
import com.geektech.rickandmorty.data.repo.CharacterRepositoryImpl
import com.geektech.rickandmorty.domain.repo.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideCharacterRepository(api: ApiService): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }

}