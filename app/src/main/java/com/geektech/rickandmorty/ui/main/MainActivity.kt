package com.geektech.rickandmorty.ui.main

import android.view.LayoutInflater
import com.geektech.rickandmorty.core.BaseActivity
import com.geektech.rickandmorty.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun initView() {

    }

    override fun initListener() {
    }
}