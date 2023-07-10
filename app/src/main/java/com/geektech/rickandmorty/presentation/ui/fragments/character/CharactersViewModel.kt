package com.geektech.rickandmorty.presentation.ui.fragments.character

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.geektech.rickandmorty.base.BaseViewModel
import com.geektech.rickandmorty.domain.use_cases.GetPagedCharactersUseCase
import com.geektech.rickandmorty.presentation.models.CharacterResultUI
import com.geektech.rickandmorty.presentation.utils.pagingCharacterResultDomainToPCRUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val getPagedCharactersUseCase: GetPagedCharactersUseCase,
) : BaseViewModel() {

    private var _getPagedCharacters =
        MutableStateFlow<PagingData<CharacterResultUI>>(PagingData.empty())
    val getPagedCharacters = _getPagedCharacters.asStateFlow()

    fun getPagedCharacters(name: String?, status: String?, gender: String?) {
        viewModelScope.launch {
            getPagedCharactersUseCase.getPagedCharacters(name, status, gender).collect {
                _getPagedCharacters.value = it.pagingCharacterResultDomainToPCRUI()
            }
        }
    }

}