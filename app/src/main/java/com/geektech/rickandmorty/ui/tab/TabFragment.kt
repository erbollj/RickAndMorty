package com.geektech.rickandmorty.ui.tab

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.core.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentTabBinding
import com.geektech.rickandmorty.ui.character.CharacterFragment
import com.geektech.rickandmorty.ui.episodes.EpisodesFragment
import com.geektech.rickandmorty.ui.location.LocationsFragment
import com.geektech.rickandmorty.ui.main.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class TabFragment : BaseFragment<FragmentTabBinding, TabViewModel>() {

    override val viewModel: TabViewModel by viewModel()
    val sharedViewModel: MainViewModel by activityViewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentTabBinding {
        return FragmentTabBinding.inflate(inflater, container, false)
    }

    override fun initView() {

        val fragmentList = arrayListOf(
            CharacterFragment(),
            LocationsFragment(),
            EpisodesFragment()
        )

        binding.viewPager.adapter = TabAdapter(fragmentList, this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Characters"
                }

                1 -> {
                    tab.text = "Locations"
                }

                else -> {
                    tab.text = "Episodes"
                }
            }
        }.attach()

    }

    override fun initListener() {

        binding.etFindCharacter.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                sharedViewModel.getSearchedCharacters(p0.toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                sharedViewModel.getSearchedCharacters(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
                sharedViewModel.getSearchedCharacters(p0.toString())
            }

        })

        binding.btnFilter.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_filterFragment)
        }

    }

}