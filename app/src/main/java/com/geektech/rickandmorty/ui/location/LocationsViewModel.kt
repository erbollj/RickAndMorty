package com.geektech.rickandmorty.ui.location

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.geektech.rickandmorty.core.BaseViewModel
import com.geektech.rickandmorty.domain.model.LocationResultDomain
import com.geektech.rickandmorty.domain.use_cases.GetPagedLocationsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationsViewModel(
    private val getPagedLocationsUseCase: GetPagedLocationsUseCase
) : BaseViewModel() {

    private val _getPagedLocations =
        MutableStateFlow<PagingData<LocationResultDomain>>(PagingData.empty())
    val getPagedLocations = _getPagedLocations.asStateFlow()

    fun getPagedLocations(name: String?) {
        viewModelScope.launch {
            getPagedLocationsUseCase.getPagedLocations(name).collect {
                _getPagedLocations.value = it
            }
        }
    }

}