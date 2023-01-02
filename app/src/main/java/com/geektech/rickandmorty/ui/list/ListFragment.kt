package com.geektech.rickandmorty.ui.list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.core.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>() {

    override val viewModel: ListViewModel by viewModels()
    private val page = 1

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        val bundleStatus = arguments?.getBundle("bundleStatus")
        val bundleGender = arguments?.getBundle("bundleGender")
        val status = bundleStatus?.getString("key1")
        val gender = bundleGender?.getString("key2")

        if (status == null && gender == null) {
            viewModel.getCharacters(page)
            viewModel.getCharacters.observe(viewLifecycleOwner) {
                val adapter = it.data?.let { it1 -> ListAdapter(it1.results) }
                binding.recycler.adapter = adapter
            }
        } else if (gender == null) {
            viewModel.getCharactersByStatus(status.toString())
            viewModel.getCharactersByStatus.observe(viewLifecycleOwner) {
                val adapter = it.data?.let { it1 -> ListAdapter(it1.results) }
                binding.recycler.adapter = adapter
            }
        } else if (status == null) {
            viewModel.getCharactersByGender(gender.toString())
            viewModel.getCharactersByGender.observe(viewLifecycleOwner) {
                val adapter = it.data?.let { it1 -> ListAdapter(it1.results) }
                binding.recycler.adapter = adapter
            }
        } else {
            viewModel.getCharactersByStatusAndGender(status.toString(), gender.toString())
            viewModel.getCharactersByStatusAndGender.observe(viewLifecycleOwner) {
                val adapter = it.data?.let { it1 -> ListAdapter(it1.results) }
                binding.recycler.adapter = adapter
            }
        }
    }

    override fun initListener() {

        binding.txtReset.setOnClickListener {
            viewModel.getCharacters(1)
            viewModel.getCharacters.observe(viewLifecycleOwner) {
                val adapter = it.data?.let { it1 -> ListAdapter(it1.results) }
                binding.recycler.adapter = adapter
            }
        }

        binding.etFindCharacter.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val name = p0.toString()
                viewModel.getCharacterByName(name)
                viewModel.getCharacterByName.observe(viewLifecycleOwner) {
                    val adapter = it.data?.let { it1 -> ListAdapter(it1.results) }
                    binding.recycler.adapter = adapter
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.btnFilter.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_filterFragment)
        }

    }

}