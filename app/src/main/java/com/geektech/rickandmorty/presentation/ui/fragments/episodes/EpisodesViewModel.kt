package com.geektech.rickandmorty.presentation.ui.fragments.episodes

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.geektech.rickandmorty.base.BaseViewModel
import com.geektech.rickandmorty.domain.use_cases.GetPagedEpisodesUseCase
import com.geektech.rickandmorty.presentation.models.EpisodeResultUI
import com.geektech.rickandmorty.presentation.utils.episodeResultDomainToEpisodeResultUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EpisodesViewModel(
    private val getPagedEpisodesUseCase: GetPagedEpisodesUseCase
) : BaseViewModel() {

    private val _getPagedEpisodes =
        MutableStateFlow<PagingData<EpisodeResultUI>>(PagingData.empty())
    val getPagedEpisodes = _getPagedEpisodes.asStateFlow()

    fun getPagedEpisodes(name: String?) {
        viewModelScope.launch {
            getPagedEpisodesUseCase.getPagedEpisodes(name).collect {
                _getPagedEpisodes.value = it.episodeResultDomainToEpisodeResultUI()
            }
        }
    }
}