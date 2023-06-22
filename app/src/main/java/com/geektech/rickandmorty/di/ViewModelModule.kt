package com.geektech.rickandmorty.di

import com.geektech.rickandmorty.ui.character.CharactersViewModel
import com.geektech.rickandmorty.ui.detail.DetailViewModel
import com.geektech.rickandmorty.ui.episodes.EpisodesViewModel
import com.geektech.rickandmorty.ui.filter.FilterViewModel
import com.geektech.rickandmorty.ui.tab.TabViewModel
import com.geektech.rickandmorty.ui.location.LocationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CharactersViewModel(get()) }
    viewModel { DetailViewModel() }
    viewModel { EpisodesViewModel(get()) }
    viewModel { FilterViewModel() }
    viewModel { TabViewModel() }
    viewModel { LocationsViewModel(get()) }
}