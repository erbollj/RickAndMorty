package com.geektech.rickandmorty.ui.episodes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.geektech.rickandmorty.core.BaseViewModel
import com.geektech.rickandmorty.core.Resource
import com.geektech.rickandmorty.core.UiState
import com.geektech.rickandmorty.domain.model.CharacterDomain
import com.geektech.rickandmorty.domain.model.EpisodeDomain
import com.geektech.rickandmorty.domain.model.EpisodeResultDomain
import com.geektech.rickandmorty.domain.use_cases.GetEpisodesUseCase
import com.geektech.rickandmorty.domain.use_cases.GetPagedEpisodesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

class EpisodesViewModel(
    private val getPagedEpisodesUseCase: GetPagedEpisodesUseCase
): BaseViewModel() {

//    private val _getEpisodes = MutableStateFlow<UiState<EpisodeDomain>>(UiState.Loading())
//    val getEpisodes = _getEpisodes.asStateFlow()
//
//    fun getEpisodes() {
//        viewModelScope.launch {
//            getEpisodesUseCase.getEpisodes().collect {
//                when (it) {
//                    is Resource.Loading -> {
//                        _getEpisodes.value = UiState.Loading()
//                    }
//                    is Resource.Error -> {
//                        _getEpisodes.value = UiState.Error(it.message.toString())
//                    }
//                    is Resource.Success -> {
//                        if (it.data != null)
//                            _getEpisodes.value = UiState.Success(it.data)
//                    }
//                }
//            }
//        }
//    }

    private val _getPagedEpisodes = MutableStateFlow<PagingData<EpisodeResultDomain>>(PagingData.empty())
    val getPagedEpisodes = _getPagedEpisodes.asStateFlow()

    fun getPagedEpisodes() {
        viewModelScope.launch {
            getPagedEpisodesUseCase.getPagedEpisodes().collect {
                _getPagedEpisodes.value = it
            }
        }
    }
}