package com.geektech.rickandmorty.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geektech.rickandmorty.core.Resource
import com.geektech.rickandmorty.core.characterDomainToCharacter
import com.geektech.rickandmorty.core.characterToCharacterDomain
import com.geektech.rickandmorty.data.network.ApiService
import com.geektech.rickandmorty.data.room.CharacterDao
import com.geektech.rickandmorty.domain.model.CharacterDomain
import com.geektech.rickandmorty.domain.repo.CharacterRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: CharacterDao
) : CharacterRepository {

    override fun getCharacters(page: Int): LiveData<Resource<CharacterDomain>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = api.getCharacters(page)
            if (result.isSuccessful) {
                Log.e("ololo", "getCharacters: " + result.body() )
                emit(Resource.success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.error(result.message()))
                Log.e("ololo", "getCharacters: " + result.code())
            }
        }

    override fun getCharactersByStatusAndGender(
        status: String,
        gender: String
    ): LiveData<Resource<CharacterDomain>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = api.getCharactersByStatusAndGender(status, gender)
        if (result.isSuccessful) {
            emit(Resource.success(result.body()!!.characterToCharacterDomain()))
        } else {
            emit(Resource.error(result.message()))
        }
    }

    override fun getCharactersByStatus(status: String): LiveData<Resource<CharacterDomain>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = api.getCharactersByStatus(status)
            if (result.isSuccessful) {
                emit(Resource.success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.error(result.message()))
            }
        }

    override fun getCharactersByGender(gender: String): LiveData<Resource<CharacterDomain>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = api.getCharactersByGender(gender)
            if (result.isSuccessful) {
                emit(Resource.success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.error(result.message()))
            }
        }

    override fun getCharacterByName(name: String): LiveData<Resource<CharacterDomain>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = api.getCharactersByName(name)
            if (result.isSuccessful) {
                emit(Resource.success(result.body()!!.characterToCharacterDomain()))
            } else {
                emit(Resource.error(result.message()))
            }
        }

    override fun addCharacter(characterDomain: CharacterDomain?): LiveData<Resource<Unit>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            try {
                if (characterDomain != null) {
                    emit(Resource.success(dao.addCharacter(characterDomain.characterDomainToCharacter())))
                }
            } catch (e: Exception) {
                emit(Resource.error(e.message.toString()))
            }
        }

    override fun getAllCharacters(): LiveData<Resource<CharacterDomain>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = dao.getAllCharacters().map { it.characterToCharacterDomain() }
            try {
                emit(Resource.success(result.component1()))
            } catch (e: Exception) {
                emit(Resource.error(e.message.toString()))
            }
        }

}