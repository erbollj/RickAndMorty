package com.geektech.rickandmorty.presentation.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.base.BaseViewModel

class TabAdapter(
    val list: ArrayList<BaseFragment<out ViewBinding, out BaseViewModel>>,
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

}