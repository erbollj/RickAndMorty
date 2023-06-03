package com.geektech.rickandmorty.di

import com.geektech.rickandmorty.ui.character.CharacterViewModel
import com.geektech.rickandmorty.ui.detail.DetailViewModel
import com.geektech.rickandmorty.ui.episodes.EpisodesViewModel
import com.geektech.rickandmorty.ui.filter.FilterViewModel
import com.geektech.rickandmorty.ui.list.ListViewModel
import com.geektech.rickandmorty.ui.location.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { DetailViewModel() }
    viewModel { EpisodesViewModel(get()) }
    viewModel { FilterViewModel() }
    viewModel { ListViewModel() }
    viewModel { LocationViewModel(get()) }
}