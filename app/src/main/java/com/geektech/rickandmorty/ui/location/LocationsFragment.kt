package com.geektech.rickandmorty.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.geektech.rickandmorty.core.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentLocationBinding
import com.geektech.rickandmorty.ui.main.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsFragment : BaseFragment<FragmentLocationBinding, LocationsViewModel>() {
    override val viewModel: LocationsViewModel by viewModel()
    private val sharedViewModel: MainViewModel by activityViewModels()
    private val adapter = LocationsAdapter()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLocationBinding {
        return FragmentLocationBinding.inflate(inflater, container, false)
    }

    override fun initView() {

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.getSearchedCharacters.collectLatest {
                    viewModel.getPagedLocations(it)
                }
            }
        }

        binding.recycler.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPagedLocations.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            )
                .collectLatest { adapter.submitData(it) }
        }

    }

    override fun initListener() {
    }

}