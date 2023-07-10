package com.geektech.rickandmorty.presentation.ui.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentDetailBinding
import com.geektech.rickandmorty.presentation.models.CharacterResultUI
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    override val viewModel: DetailViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun initView() {

        binding.apply {
            val it = arguments?.getSerializable("result") as CharacterResultUI
            run {
                txtIsAlive.text = it.status
                txtGenderOfCharacter.text = it.gender
                txtNameOfCharacter.text = it.name
                txtLocationOfCharacter.text = it.locationDomain.name
                Glide.with(imgOfCharacter).load(it.image).into(imgOfCharacter)
            }.toString()
        }

    }

    override fun initListener() {

    }


}