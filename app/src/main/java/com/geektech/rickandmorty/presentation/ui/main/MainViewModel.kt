package com.geektech.rickandmorty.presentation.ui.main

import com.geektech.rickandmorty.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : BaseViewModel() {

    private val _getSearchedCharacters = MutableStateFlow<String?>(null)
    val getSearchedCharacters = _getSearchedCharacters.asStateFlow()

    fun getSearchedCharacters(name: String?) {
        _getSearchedCharacters.value = name
    }

    private val _getCharactersWithStatus = MutableStateFlow<String?>(null)
    val getCharactersWithStatus = _getCharactersWithStatus.asStateFlow()

    fun getCharactersWithStatus(status: String?) {
        _getCharactersWithStatus.value = status
    }

    private val _getCharactersWithGender = MutableStateFlow<String?>(null)
    val getCharactersWithGender = _getCharactersWithGender.asStateFlow()

    fun getCharactersWithGender(gender: String?) {
        _getCharactersWithGender.value = gender
    }

}