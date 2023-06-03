package com.geektech.rickandmorty.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.geektech.rickandmorty.core.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentListBinding
import com.geektech.rickandmorty.ui.character.CharacterFragment
import com.geektech.rickandmorty.ui.episodes.EpisodesFragment
import com.geektech.rickandmorty.ui.location.LocationFragment
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>() {

    override val viewModel: ListViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }

    override fun initView() {

        val fragmentList = arrayListOf(
            CharacterFragment(),
            LocationFragment(),
            EpisodesFragment()
        )

        binding.viewPager.adapter = ListAdapter(fragmentList, this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            val number = position + 1
            tab.text = "Tab $number"
        }.attach()

    }

    override fun initListener() {

    }

}