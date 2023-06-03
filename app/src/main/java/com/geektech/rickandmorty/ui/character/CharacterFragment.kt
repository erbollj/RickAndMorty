package com.geektech.rickandmorty.ui.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.geektech.rickandmorty.core.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentCharacterBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel>() {

    override val viewModel: CharacterViewModel by viewModel()
    private val adapter = CharactersAdapter()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentCharacterBinding {
        return FragmentCharacterBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        val bundleStatus = arguments?.getBundle("bundleStatus")
        val bundleGender = arguments?.getBundle("bundleGender")
        val status = bundleStatus?.getString("key1")
        val gender = bundleGender?.getString("key2")
//        if (status == null && gender == null) {
//        viewModel.getCharacters()
//
//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.getCharacters.flowWithLifecycle(
//                viewLifecycleOwner.lifecycle,
//                Lifecycle.State.STARTED
//            )
//                .distinctUntilChanged()
//                .collect {
//                    when (it) {
//                        is UiState.Loading -> {
//                        }
//                        is UiState.Error -> {
//                            Log.e("ololo", "initView: " + it.message)
//                        }  
//                        is UiState.Success -> {
//                            val result = it.data.resultsDomain
//                        }
//                    }
//                }
//        }
        viewModel.getPagedCharacters()
                viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPagedCharacters.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            )
                .distinctUntilChanged()
                .collectLatest {
                    binding.recycler.adapter = adapter
                    adapter.submitData(it)
                }

        }


//        } else if (gender == null) {
//
//            viewModel.getCharactersByStatus(status.toString())
//            viewModel.getCharactersByStatus.observe(viewLifecycleOwner) {
//                val adapter = it.data?.let { it1 -> CharacterAdapter(it1.resultsDomain) }
//                binding.recycler.adapter = adapter
//            }
//
//        } else if (status == null) {
//
//            viewModel.getCharactersByGender(gender.toString())
//            viewModel.getCharactersByGender.observe(viewLifecycleOwner) {
//                val adapter = it.data?.let { it1 -> CharacterAdapter(it1.resultsDomain) }
//                binding.recycler.adapter = adapter
//            }
//
//        } else {
//
//            viewModel.getCharactersByStatusAndGender(status.toString(), gender.toString())
//            viewModel.getCharactersByStatusAndGender.observe(viewLifecycleOwner) {
//                val adapter = it.data?.let { it1 -> CharacterAdapter(it1.resultsDomain) }
//                binding.recycler.adapter = adapter
//            }
    }

    override fun initListener() {

//        binding.etFindCharacter.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                val name = p0.toString()
//
//                viewModel.getCharacterByName(name)
//                viewModel.getCharacterByName.observe(viewLifecycleOwner) {
//                    val adapter = it.data?.let { it1 -> ListAdapter(it1.resultsDomain) }
//                    binding.recycler.adapter = adapter
//                }
//
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//        })
//
//        binding.btnFilter.setOnClickListener {
//            findNavController().navigate(R.id.action_listFragment_to_filterFragment)
//        }
    }

}