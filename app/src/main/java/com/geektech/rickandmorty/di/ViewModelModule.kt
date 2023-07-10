package com.geektech.rickandmorty.di

import com.geektech.rickandmorty.presentation.ui.fragments.character.CharactersViewModel
import com.geektech.rickandmorty.presentation.ui.fragments.detail.DetailViewModel
import com.geektech.rickandmorty.presentation.ui.fragments.episodes.EpisodesViewModel
import com.geektech.rickandmorty.presentation.ui.fragments.filter.FilterViewModel
import com.geektech.rickandmorty.presentation.ui.fragments.location.LocationsViewModel
import com.geektech.rickandmorty.presentation.ui.fragments.tab.TabViewModel
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