package com.geektech.rickandmorty.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.geektech.rickandmorty.core.BaseViewModel
import com.geektech.rickandmorty.domain.use_cases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getCharactersByStatusAndGenderUseCase: GetCharactersByStatusAndGenderUseCase,
    private val getCharactersByStatusUseCase: GetCharactersByStatusUseCase,
    private val getCharactersByGenderUseCase: GetCharactersByGenderUseCase,
    private val getCharactersByNameUseCase: GetCharacterByNameUseCase
) : BaseViewModel(){

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