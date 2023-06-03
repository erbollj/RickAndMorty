package com.geektech.rickandmorty.ui.character

import androidx.lifecycle.viewModelScope

import androidx.paging.PagingData
import com.geektech.rickandmorty.core.BaseViewModel
import com.geektech.rickandmorty.core.Resource
import com.geektech.rickandmorty.core.UiState
import com.geektech.rickandmorty.domain.model.CharacterDomain
import com.geektech.rickandmorty.domain.model.CharacterResultDomain
import com.geektech.rickandmorty.domain.use_cases.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val getPagedCharactersUseCase: GetPagedCharactersUseCase,
) : BaseViewModel() {

//    private val _getCharacters = MutableStateFlow<UiState<CharacterDomain>>(UiState.Loading())
//    val getCharacters = _getCharacters.asStateFlow()
//
//    fun getCharacters() {
//        viewModelScope.launch {
//            getCharactersUseCase.getCharacters().collect {
//                when (it) {
//                    is Resource.Loading -> {
//                        _getCharacters.value = UiState.Loading()
//                    }
//                    is Resource.Error -> {
//                        _getCharacters.value = UiState.Error(it.message.toString())
//                    }
//                    is Resource.Success -> {
//                        if (it.data != null) {
//                            _getCharacters.value = UiState.Success(it.data)
//                        }
//                    }
//                }
//            }
//        }
//    }

    private val _getPagedCharacters = MutableStateFlow<PagingData<CharacterResultDomain>>(PagingData.empty())
    val getPagedCharacters = _getPagedCharacters.asStateFlow()

    fun getPagedCharacters() {
        viewModelScope.launch {
            getPagedCharactersUseCase.getPagedCharacters().collect {
                _getPagedCharacters.value = it
            }
        }

    }

//    private val _getCharactersByStatusAndGender = MutableStateFlow<UiState<CharacterDomain>>(UiState.Loading())
//    val getCharactersByStatusAndGender = _getCharactersByStatusAndGender.asStateFlow()
//
//     suspend fun getCharactersByStatusAndGender(status: String, gender: String) {
//        getCharactersByStatusAndGenderUseCase.getCharactersByStatusAndGender(status, gender).collect {
//            when (it) {
//                is Resource.Loading -> {
//                    _getCharactersByStatusAndGender.value = UiState.Loading()
//                }
//                is Resource.Error -> {
//                    _getCharactersByStatusAndGender.value = UiState.Error(it.message.toString())
//                }
//                is Resource.Success -> {
//                    if (it.data == null) {
//                        _getCharactersByStatusAndGender.value = it.data?.let { it1 ->
//                            UiState.Success(
//                                it1
//                            )
//                        }!!
//                    }
//                }
//            }
//        }
//    }
//
//    private val _getCharactersByStatus = MutableLiveData<String>()
//    val getCharactersByStatus = _getCharactersByStatus.switchMap {
//        getCharactersByStatusUseCase.getCharactersByStatus(it)
//    }
//
//    fun getCharactersByStatus(status: String) {
//        _getCharactersByStatus.postValue(status)
//    }
//
//    private val _getCharactersByGender = MutableLiveData<String>()
//    val getCharactersByGender = _getCharactersByGender.switchMap {
//        getCharactersByGenderUseCase.getCharactersByGender(it)
//    }
//
//    fun getCharactersByGender(gender: String) {
//        _getCharactersByGender.postValue(gender)
//    }
//
//    private val _getCharacterByName = MutableLiveData<String>()
//    val getCharacterByName = _getCharacterByName.switchMap {
//        getCharactersByNameUseCase.getCharacterByName(it)
//    }
//
//    fun getCharacterByName(name: String) {
//        _getCharacterByName.postValue(name)
//    }

}