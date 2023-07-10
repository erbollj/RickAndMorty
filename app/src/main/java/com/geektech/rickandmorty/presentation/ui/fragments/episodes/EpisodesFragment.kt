package com.geektech.rickandmorty.presentation.ui.fragments.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentEpisodesBinding
import com.geektech.rickandmorty.presentation.ui.adapters.EpisodesAdapter
import com.geektech.rickandmorty.presentation.ui.main.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding, EpisodesViewModel>() {
    override val viewModel: EpisodesViewModel by viewModel()
    private val sharedViewModel: MainViewModel by activityViewModels()
    private val adapter = EpisodesAdapter()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentEpisodesBinding {
        return FragmentEpisodesBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.getSearchedCharacters.collectLatest {
                    viewModel.getPagedEpisodes(it)

                }
            }
        }

        binding.recycler.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPagedEpisodes.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            )
                .collectLatest { adapter.submitData(it) }
        }
    }

    override fun initListener() {
    }
}