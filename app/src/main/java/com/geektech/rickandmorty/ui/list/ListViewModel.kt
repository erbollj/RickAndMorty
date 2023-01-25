package com.geektech.rickandmorty.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.geektech.rickandmorty.core.BaseViewModel
import com.geektech.rickandmorty.domain.model.CharacterDomain
import com.geektech.rickandmorty.domain.use_cases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getCharactersByStatusAndGenderUseCase: GetCharactersByStatusAndGenderUseCase,
    private val getCharactersByStatusUseCase: GetCharactersByStatusUseCase,
    private val getCharactersByGenderUseCase: GetCharactersByGenderUseCase,
    private val getCharactersByNameUseCase: GetCharacterByNameUseCase,
    private val addCharacterUseCase: AddCharacterUseCase,
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : BaseViewModel(){

    private val _getCharacters = MutableLiveData<Int>()
    val getCharacters = _getCharacters.switchMap {
        getCharactersUseCase.getCharacters(it)
    }

    fun getCharacters(page: Int) {
        _getCharacters.postValue(page)
    }

    private val _getCharactersByStatusAndGender = MutableLiveData<List<String>>()
    val getCharactersByStatusAndGender = _getCharactersByStatusAndGender.switchMap {
        getCharactersByStatusAndGenderUseCase.getCharactersByStatusAndGender(it[0], it[1])
    }

    fun getCharactersByStatusAndGender(status: String, gender: String) {
        val data = listOf(status, gender)
        _getCharactersByStatusAndGender.postValue(data)
    }

    private val _getCharactersByStatus = MutableLiveData<String>()
    val getCharactersByStatus = _getCharactersByStatus.switchMap {
        getCharactersByStatusUseCase.getCharactersByStatus(it)
    }

    fun getCharactersByStatus(status: String) {
        _getCharactersByStatus.postValue(status)
    }

    private val _getCharactersByGender = MutableLiveData<String>()
    val getCharactersByGender = _getCharactersByGender.switchMap {
        getCharactersByGenderUseCase.getCharactersByGender(it)
    }

    fun getCharactersByGender(gender: String) {
        _getCharactersByGender.postValue(gender)
    }

    private val _getCharacterByName = MutableLiveData<String>()
    val getCharacterByName = _getCharacterByName.switchMap {
        getCharactersByNameUseCase.getCharacterByName(it)
    }

    fun getCharacterByName(name: String) {
        _getCharacterByName.postValue(name)
    }

    private val _addCharacter = MutableLiveData<CharacterDomain>()
    val addCharacter = _addCharacter.switchMap {
        addCharacterUseCase.addCharacter(it)
    }

    fun addCharacter(characterDomain: CharacterDomain) {
        _addCharacter.postValue(characterDomain)
    }

    private val _getAllCharacters = MutableLiveData<Boolean>()
    val getAllCharacters = _getAllCharacters.switchMap {
        getAllCharactersUseCase.getAllCharacters()
    }

    fun getAllCharacters() {
        _getAllCharacters.postValue(true)
    }

}