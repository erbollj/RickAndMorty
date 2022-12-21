package com.geektech.rickandmorty.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geektech.rickandmorty.Resource
import com.geektech.rickandmorty.model.Character
import com.geektech.rickandmorty.network.RetrofitClient
import kotlinx.coroutines.Dispatchers

class Repository {

    fun getCharacters(page:Int): LiveData<Resource<Character?>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = RetrofitClient.api.getCharacters(page)
        if (result.isSuccessful) {
            emit(Resource.success(result.body()))
        } else {
            emit(Resource.error("govno"))
            Log.e("ololo", "getCharacters: " + result.code() )
        }
    }

    fun getCharactersByStatusAndGender(status: String, gender: String): LiveData<Resource<Character?>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = RetrofitClient.api.getCharactersByStatusAndGender(status, gender)
        if (result.isSuccessful) {
            emit(Resource.success(result.body()))
        } else {
            emit(Resource.error(result.message()))
        }
    }

    fun getCharactersByStatus(status: String) : LiveData<Resource<Character?>> = liveData (Dispatchers.IO) {
        emit(Resource.loading())
        val result = RetrofitClient.api.getCharactersByStatus(status)
        if (result.isSuccessful) {
            emit(Resource.success(result.body()))
        } else {
            emit(Resource.error(result.message()))
        }
    }

    fun getCharactersByGender(gender: String): LiveData<Resource<Character?>> = liveData (Dispatchers.IO) {
        emit(Resource.loading())
        val result = RetrofitClient.api.getCharactersByGender(gender)
        if (result.isSuccessful) {
            emit(Resource.success(result.body()))
        } else {
            emit(Resource.error(result.message()))
        }
    }

}