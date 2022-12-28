package com.geektech.rickandmorty.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geektech.rickandmorty.core.Resource
import com.geektech.rickandmorty.core.characterToCharacterDomain
import com.geektech.rickandmorty.data.network.RetrofitClient
import com.geektech.rickandmorty.domain.model.CharacterDomain
import com.geektech.rickandmorty.domain.repo.CharacterRepository
import kotlinx.coroutines.Dispatchers

class CharacterRepositoryImpl : CharacterRepository {

    override fun getCharacters(page: Int): LiveData<Resource<CharacterDomain>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = RetrofitClient.api.getCharacters(page)
            if (result.isSuccessful) {
                emit(Resource.success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.error("govno"))
                Log.e("ololo", "getCharacters: " + result.code())
            }
        }

    override fun getCharactersByStatusAndGender(
        status: String,
        gender: String
    ): LiveData<Resource<CharacterDomain>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = RetrofitClient.api.getCharactersByStatusAndGender(status, gender)
        if (result.isSuccessful) {
            emit(Resource.success(result.body()!!.characterToCharacterDomain()))
        } else {
            emit(Resource.error(result.message()))
        }
    }

    override fun getCharactersByStatus(status: String): LiveData<Resource<CharacterDomain>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = RetrofitClient.api.getCharactersByStatus(status)
            if (result.isSuccessful) {
                emit(Resource.success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.error(result.message()))
            }
        }

    override fun getCharactersByGender(gender: String): LiveData<Resource<CharacterDomain>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = RetrofitClient.api.getCharactersByGender(gender)
            if (result.isSuccessful) {
                emit(Resource.success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.error(result.message()))
            }
        }

    override fun getCharacterByName(name: String): LiveData<Resource<CharacterDomain>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = RetrofitClient.api.getCharactersByName(name)
            if (result.isSuccessful) {
                emit(Resource.success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.error(result.message()))
            }
        }

    //    fun getCharacters(page:Int): LiveData<Resource<Character?>> = liveData(Dispatchers.IO) {
//        emit(Resource.loading())
//        val result = RetrofitClient.api.getCharacters(page)
//        if (result.isSuccessful) {
//            emit(Resource.success(result.body()))
//        } else {
//            emit(Resource.error("govno"))
//            Log.e("ololo", "getCharacters: " + result.code() )
//        }
//    }
//
//    fun getCharactersByStatusAndGender(status: String, gender: String): LiveData<Resource<Character?>> = liveData(Dispatchers.IO) {
//        emit(Resource.loading())
//        val result = RetrofitClient.api.getCharactersByStatusAndGender(status, gender)
//        if (result.isSuccessful) {
//            emit(Resource.success(result.body()))
//        } else {
//            emit(Resource.error(result.message()))
//        }
//    }
//
//    fun getCharactersByName(name: String): LiveData<Resource<Character?>> = liveData(Dispatchers.IO) {
//        emit(Resource.loading())
//        val result = RetrofitClient.api.getCharactersByName(name)
//        if (result.isSuccessful) {
//            emit(Resource.success(result.body()))
//        } else {
//            emit(Resource.error(result.message()))
//        }
//    }
//
//    fun getCharactersByStatus(status: String) : LiveData<Resource<Character?>> = liveData (Dispatchers.IO) {
//        emit(Resource.loading())
//        val result = RetrofitClient.api.getCharactersByStatus(status)
//        if (result.isSuccessful) {
//            emit(Resource.success(result.body()))
//        } else {
//            emit(Resource.error(result.message()))
//        }
//    }
//
//    fun getCharactersByGender(gender: String): LiveData<Resource<Character?>> = liveData (Dispatchers.IO) {
//        emit(Resource.loading())
//        val result = RetrofitClient.api.getCharactersByGender(gender)
//        if (result.isSuccessful) {
//            emit(Resource.success(result.body()))
//        } else {
//            emit(Resource.error(result.message()))
//        }
//    }

}