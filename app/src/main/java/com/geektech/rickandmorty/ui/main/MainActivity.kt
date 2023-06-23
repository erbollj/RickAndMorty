package com.geektech.rickandmorty.ui.main

import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.core.BaseActivity
import com.geektech.rickandmorty.core.NetworkStatusTracker
import com.geektech.rickandmorty.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(
            this,
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val networkStatusTracker = NetworkStatusTracker(this@MainActivity)
                    return MainViewModel(networkStatusTracker) as T
                }
            },
        )[MainViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun initView() {
        viewModel.state.observe(this) { state ->
            val navController = findNavController(R.id.nav_host_fragment)
            val navGraph = navController.graph
            navController.graph = navGraph
            when (state) {
                MainViewModel.MyState.Fetched -> Log.e("ololo", "initView: bar" )
                MainViewModel.MyState.Error -> Log.e("ololo", "initView: jok", )
            }
        }
    }

    override fun initListener() {
    }
}