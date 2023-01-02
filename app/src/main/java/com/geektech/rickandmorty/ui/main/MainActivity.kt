package com.geektech.rickandmorty.ui.main

import android.view.LayoutInflater
import com.geektech.rickandmorty.core.BaseActivity
import com.geektech.rickandmorty.data.repo.CharacterRepositoryImpl
import com.geektech.rickandmorty.databinding.ActivityMainBinding
import com.geektech.rickandmorty.domain.repo.CharacterRepository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun initView() {
    }

    override fun initListener() {
    }
}