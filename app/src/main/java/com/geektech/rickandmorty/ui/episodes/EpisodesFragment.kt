package com.geektech.rickandmorty.ui.episodes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.geektech.rickandmorty.core.BaseFragment
import com.geektech.rickandmorty.core.UiState
import com.geektech.rickandmorty.databinding.FragmentEpisodesBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding, EpisodesViewModel>() {
    override val viewModel: EpisodesViewModel by viewModel()
    private val adapter = EpisodesAdapter()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentEpisodesBinding {
        return FragmentEpisodesBinding.inflate(inflater, container, false)
    }

    override fun initView() {
//        viewModel.getEpisodes()
//
//        lifecycleScope.launch {
//            viewModel.getEpisodes.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
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
//                        val adapter = result.let { it1 -> EpisodeAdapter(it1) }
//                        binding.recycler.adapter = adapter
//                    }
//                }
//            }
//        }

        viewModel.getPagedEpisodes()
        binding.recycler.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPagedEpisodes.flowWithLifecycle(
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