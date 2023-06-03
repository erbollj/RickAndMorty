package com.geektech.rickandmorty.ui.location

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.geektech.rickandmorty.core.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentLocationBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<FragmentLocationBinding, LocationViewModel>() {
    override val viewModel: LocationViewModel by viewModel()
    private val adapter = LocationsAdapter()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLocationBinding {
        return FragmentLocationBinding.inflate(inflater, container, false)
    }

    override fun initView() {
//        viewModel.getLocation()
//
//        lifecycleScope.launch {
//            viewModel.getLocations.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
//                .distinctUntilChanged()
//                .collect {
//                when (it) {
//                    is UiState.Loading -> {
//                    }
//                    is UiState.Error -> {
//                        Log.e("ololo", "initView: " + it.message )
//                    }
//                    is UiState.Success -> {
//                        val result = it.data.results
//                        val adapter = result.let { it1 -> LocationAdapter(it1) }
//                        binding.recycler.adapter = adapter
//                    }
//                }
//            }
//        }

        viewModel.getPagedLocations()
        binding.recycler.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPagedLocations.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            )
                .distinctUntilChanged()
                .collectLatest { adapter.submitData(it) }
        }


    }

    override fun initListener() {
    }

}