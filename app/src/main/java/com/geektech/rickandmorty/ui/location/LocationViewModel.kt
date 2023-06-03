package com.geektech.rickandmorty.ui.location

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.geektech.rickandmorty.core.BaseViewModel
import com.geektech.rickandmorty.core.Resource
import com.geektech.rickandmorty.core.UiState
import com.geektech.rickandmorty.domain.model.LocationDomain
import com.geektech.rickandmorty.domain.model.LocationResultDomain
import com.geektech.rickandmorty.domain.use_cases.GetLocationsUseCase
import com.geektech.rickandmorty.domain.use_cases.GetPagedLocationsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationViewModel(
        private val getPagedLocationsUseCase: GetPagedLocationsUseCase
): BaseViewModel() {

//    private val _getLocations = MutableStateFlow<UiState<LocationDomain>>(UiState.Loading())
//    val getLocations = _getLocations.asStateFlow()
//
//    fun getLocation() {
//        viewModelScope.launch {
//            getLocationsUseCase.getLocations().collect {
//                when (it) {
//                    is Resource.Loading -> {
//                        _getLocations.value = UiState.Loading()
//                    }
//                    is Resource.Error -> {
//                        _getLocations.value = UiState.Error(it.message.toString())
//                    }
//                    is Resource.Success -> {
//                        if (it.data != null)
//                        _getLocations.value = UiState.Success(it.data)
//                    }
//                }
//            }
//        }
//
//    }

    private val _getPagedLocations = MutableStateFlow<PagingData<LocationResultDomain>>(PagingData.empty())
    val getPagedLocations = _getPagedLocations.asStateFlow()

    fun getPagedLocations() {
        viewModelScope.launch {
            getPagedLocationsUseCase.getPagedLocations().collect {
                _getPagedLocations.value = it
            }
        }
    }

}