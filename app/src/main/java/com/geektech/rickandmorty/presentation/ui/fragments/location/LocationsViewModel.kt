package com.geektech.rickandmorty.presentation.ui.fragments.location

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.geektech.rickandmorty.base.BaseViewModel
import com.geektech.rickandmorty.domain.use_cases.GetPagedLocationsUseCase
import com.geektech.rickandmorty.presentation.models.LocationResultUI
import com.geektech.rickandmorty.presentation.utils.locationResultTDomainLocationResultUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationsViewModel(
    private val getPagedLocationsUseCase: GetPagedLocationsUseCase
) : BaseViewModel() {

    private val _getPagedLocations =
        MutableStateFlow<PagingData<LocationResultUI>>(PagingData.empty())
    val getPagedLocations = _getPagedLocations.asStateFlow()

    fun getPagedLocations(name: String?) {
        viewModelScope.launch {
            getPagedLocationsUseCase.getPagedLocations(name).collect {
                _getPagedLocations.value = it.locationResultTDomainLocationResultUI()
            }
        }
    }

}