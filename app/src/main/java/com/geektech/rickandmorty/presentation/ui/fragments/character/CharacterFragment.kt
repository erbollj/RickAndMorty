package com.geektech.rickandmorty.presentation.ui.fragments.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentCharacterBinding
import com.geektech.rickandmorty.presentation.ui.adapters.CharactersAdapter
import com.geektech.rickandmorty.presentation.ui.main.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharactersViewModel>() {

    override val viewModel: CharactersViewModel by viewModel()
    private val sharedViewModel: MainViewModel by activityViewModels()
    private val adapter = CharactersAdapter()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentCharacterBinding {
        return FragmentCharacterBinding.inflate(inflater, container, false)
    }

    override fun initView() {

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.getSearchedCharacters.collectLatest {
                    viewModel.getPagedCharacters(it, null, null)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.getCharactersWithStatus.collectLatest { status ->
                    sharedViewModel.getCharactersWithGender.collectLatest { gender ->
                        viewModel.getPagedCharacters(null, status, gender)
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getPagedCharacters.collectLatest {
                    binding.recycler.adapter = adapter
                    adapter.submitData(it)
                }
            }
        }

    }

    override fun initListener() {

    }

}