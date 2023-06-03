package com.geektech.rickandmorty.ui.list
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.geektech.rickandmorty.core.BaseFragment
import com.geektech.rickandmorty.core.BaseViewModel

class ListAdapter(
    val list: ArrayList<BaseFragment<out ViewBinding, out BaseViewModel>>,
    fragment: Fragment
): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

}