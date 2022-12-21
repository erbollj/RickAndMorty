package com.geektech.rickandmorty.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentListBinding

class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>() {

    override val viewModel: ListViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        val page = 1
        val bundleStatus = arguments?.getBundle("bundleStatus")
        val bundleGender = arguments?.getBundle("bundleGender")
        val status = bundleStatus?.getString("key1")
        val gender = bundleGender?.getString("key2")

        if (status == null && gender == null) {
            viewModel.getCharacters(page)
            viewModel.characters.observe(viewLifecycleOwner) {
                val adapter = it.data?.let { it1 -> ListAdapter(it1.results) }
                binding.recycler.adapter = adapter
            }
        } else if (gender == null) {
            viewModel.getCharactersByStatus(status.toString())
            viewModel.filterByStatus.observe(viewLifecycleOwner) {
                val adapter = it.data?.let { it1 -> ListAdapter(it1.results) }
                binding.recycler.adapter = adapter
            }
        } else if (status == null) {
            viewModel.getCharactersByGender(gender.toString())
            viewModel.filterByGender.observe(viewLifecycleOwner) {
                val adapter = it.data?.let { it1 -> ListAdapter(it1.results) }
                binding.recycler.adapter = adapter
            }
        } else {
            viewModel.getCharactersByStatusAndGender(status.toString(), gender.toString())
            viewModel.filterByStatusAndGender.observe(viewLifecycleOwner) {
                val adapter = it.data?.let { it1 -> ListAdapter(it1.results) }
                binding.recycler.adapter = adapter
            }
        }
    }

    override fun initListener() {

        binding.txtReset.setOnClickListener {
            viewModel.getCharacters(1)
            viewModel.characters.observe(viewLifecycleOwner) {
                val adapter = it.data?.let { it1 -> ListAdapter(it1.results) }
                binding.recycler.adapter = adapter
            }
        }

        binding.btnFilter.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_filterFragment)
        }

    }

}