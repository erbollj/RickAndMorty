package com.geektech.rickandmorty.ui.main

import androidx.lifecycle.asLiveData
import com.geektech.rickandmorty.core.BaseViewModel
import com.geektech.rickandmorty.core.NetworkStatusTracker
import com.geektech.rickandmorty.core.map
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
    networkStatusTracker: NetworkStatusTracker,
) : BaseViewModel() {
    sealed class MyState {
        object Fetched : MyState()
        object Error : MyState()
    }

    val state =
        networkStatusTracker.networkStatus
            .map(
                onUnavailable = { MyState.Error },
                onAvailable = { MyState.Fetched },
            )
            .asLiveData(Dispatchers.IO)


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