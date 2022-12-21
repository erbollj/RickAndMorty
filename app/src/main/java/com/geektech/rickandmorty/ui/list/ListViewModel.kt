package com.geektech.rickandmorty.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.geektech.rickandmorty.base.BaseViewModel
import com.geektech.rickandmorty.repo.Repository

class ListViewModel: BaseViewModel() {
    private val repo= Repository()
    private val _characters = MutableLiveData<Int>()
    private val _filterByStatusAndGender = MutableLiveData<List<String>>()
    private val _filterByStatus = MutableLiveData<String>()
    private val _filterByGender = MutableLiveData<String>()

    val filterByStatusAndGender= _filterByStatusAndGender.switchMap {
        repo.getCharactersByStatusAndGender(it[0], it[1])
    }

    val characters = _characters.switchMap {
        repo.getCharacters(it)
    }

    val filterByStatus = _filterByStatus.switchMap {
        repo.getCharactersByStatus(it)
    }

    val filterByGender = _filterByGender.switchMap {
        repo.getCharactersByGender(it)
    }

    fun getCharactersByStatus(status: String) {
        _filterByStatus.postValue(status)
    }

    fun getCharactersByGender(gender: String) {
        _filterByGender.postValue(gender)
    }

    fun getCharactersByStatusAndGender(status: String, gender: String) {
        val arrayGenderAndStatus = listOf(status, gender)
        _filterByStatusAndGender.postValue(arrayGenderAndStatus)
    }
    fun getCharacters(page: Int) {
        _characters.postValue(page)
    }

}