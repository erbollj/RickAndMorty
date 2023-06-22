package com.geektech.rickandmorty.ui.episodes

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.geektech.rickandmorty.core.BaseViewModel
import com.geektech.rickandmorty.domain.model.EpisodeResultDomain
import com.geektech.rickandmorty.domain.use_cases.GetPagedEpisodesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EpisodesViewModel(
    private val getPagedEpisodesUseCase: GetPagedEpisodesUseCase
) : BaseViewModel() {

    private val _getPagedEpisodes =
        MutableStateFlow<PagingData<EpisodeResultDomain>>(PagingData.empty())
    val getPagedEpisodes = _getPagedEpisodes.asStateFlow()

    fun getPagedEpisodes(name: String?) {
        viewModelScope.launch {
            getPagedEpisodesUseCase.getPagedEpisodes(name).collect {
                _getPagedEpisodes.value = it
            }
        }
    }
}