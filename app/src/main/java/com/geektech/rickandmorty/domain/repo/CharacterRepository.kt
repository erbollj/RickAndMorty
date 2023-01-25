package com.geektech.rickandmorty.domain.repo

import androidx.lifecycle.LiveData
import com.geektech.rickandmorty.core.Resource
import com.geektech.rickandmorty.domain.model.CharacterDomain

interface CharacterRepository {

    fun getCharacters(page: Int): LiveData<Resource<CharacterDomain>>

    fun getCharactersByStatusAndGender(status: String, gender: String): LiveData<Resource<CharacterDomain>>

    fun getCharactersByStatus(status: String): LiveData<Resource<CharacterDomain>>

    fun getCharactersByGender(gender: String): LiveData<Resource<CharacterDomain>>

    fun getCharacterByName(name: String): LiveData<Resource<CharacterDomain>>

    fun addCharacter(characterDomain: CharacterDomain?): LiveData<Resource<Unit>>

    fun getAllCharacters(): LiveData<Resource<CharacterDomain>>

}