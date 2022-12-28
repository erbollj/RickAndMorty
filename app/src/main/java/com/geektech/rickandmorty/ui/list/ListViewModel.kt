package com.geektech.rickandmorty.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.geektech.rickandmorty.core.BaseViewModel
import com.geektech.rickandmorty.data.repo.CharacterRepositoryImpl
import com.geektech.rickandmorty.domain.use_cases.*

class ListViewModel: BaseViewModel(){
    val repo = CharacterRepositoryImpl()
    private val getCharactersUseCase = GetCharactersUseCase(repo)
    private val getCharactersByStatusAndGenderUseCase
    = GetCharactersByStatusAndGenderUseCase(repo)
    private val getCharactersByStatusUseCase = GetCharactersByStatusUseCase(repo)
    private val getCharactersByGenderUseCase = GetCharactersByGenderUseCase(repo)
    private val getCharactersByNameUseCase = GetCharacterByNameUseCase(repo)

    private val _getCharacters = MutableLiveData<Int>()
    val getCharacters = _getCharacters.switchMap {
        getCharactersUseCase.getCharacters(it)
    }

    private val _getCharactersByStatusAndGender = MutableLiveData<List<String>>()
    val getCharactersByStatusAndGender = _getCharactersByStatusAndGender.switchMap {
        getCharactersByStatusAndGenderUseCase.getCharactersByStatusAndGender(it[0], it[1])
    }

    private val _getCharactersByStatus = MutableLiveData<String>()
    val getCharactersByStatus = _getCharactersByStatus.switchMap {
        getCharactersByStatusUseCase.getCharactersByStatus(it)
    }

    private val _getCharactersByGender = MutableLiveData<String>()
    val getCharactersByGender = _getCharactersByGender.switchMap {
        getCharactersByGenderUseCase.getCharactersByGender(it)
    }

    private val _getCharacterByName = MutableLiveData<String>()
    val getCharacterByName = _getCharacterByName.switchMap {
        getCharactersByNameUseCase.getCharacterByName(it)
    }

    fun getCharacters(page: Int) {
        _getCharacters.postValue(page)
    }

    fun getCharactersByStatusAndGender(status: String, gender: String) {
        val data = listOf(status, gender)
        _getCharactersByStatusAndGender.postValue(data)
    }

    fun getCharactersByStatus(status: String) {
        _getCharactersByStatus.postValue(status)
    }

    fun getCharactersByGender(gender: String) {
        _getCharactersByGender.postValue(gender)
    }

    fun getCharacterByName(name: String) {
        _getCharacterByName.postValue(name)
    }

//    val filterByStatusAndGender= _filterByStatusAndGender.switchMap {
//        repo.getCharactersByStatusAndGender(it[0], it[1])
//    }
//
//    val filterByName = _filterByName.switchMap {
//        repo.getCharacterByName(it)
//    }
//
//    val characters = _characters.switchMap {
//        repo.getCharacters(it)
//    }
//
//    val filterByStatus = _filterByStatus.switchMap {
//        repo.getCharactersByStatus(it)
//    }
//
//    val filterByGender = _filterByGender.switchMap {
//        repo.getCharactersByGender(it)
//    }
//
//    fun getCharactersByStatus(status: String) {
//        _filterByStatus.postValue(status)
//    }
//
//    fun getCharactersByName(name:String) {
//        _filterByName.postValue(name)
//    }
//
//    fun getCharactersByGender(gender: String) {
//        _filterByGender.postValue(gender)
//    }
//
//    fun getCharactersByStatusAndGender(status: String, gender: String) {
//        val arrayGenderAndStatus = listOf(status, gender)
//        _filterByStatusAndGender.postValue(arrayGenderAndStatus)
//    }
//    fun getCharacters(page: Int) {
//        _characters.postValue(page)
//    }

}