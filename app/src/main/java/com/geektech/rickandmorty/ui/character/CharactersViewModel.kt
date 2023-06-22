package com.geektech.rickandmorty.ui.character

import androidx.lifecycle.viewModelScope

import androidx.paging.PagingData
import com.geektech.rickandmorty.core.BaseViewModel
import com.geektech.rickandmorty.domain.model.CharacterResultDomain
import com.geektech.rickandmorty.domain.use_cases.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val getPagedCharactersUseCase: GetPagedCharactersUseCase,
) : BaseViewModel() {

    private var _getPagedCharacters =
        MutableStateFlow<PagingData<CharacterResultDomain>>(PagingData.empty())
    val getPagedCharacters = _getPagedCharacters.asStateFlow()

    fun getPagedCharacters(name: String?, status: String?, gender: String?) {
        viewModelScope.launch {
            getPagedCharactersUseCase.getPagedCharacters(name, status, gender).collect {
                _getPagedCharacters.value = it
            }
        }
    }

}