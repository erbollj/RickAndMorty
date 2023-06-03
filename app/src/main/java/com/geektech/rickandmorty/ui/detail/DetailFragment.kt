package com.geektech.rickandmorty.ui.detail
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.geektech.rickandmorty.core.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    override val viewModel: DetailViewModel by viewModel()
    private val args by navArgs<DetailFragmentArgs>()



    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        binding.apply {
            txtIsAlive.text = args.currentResult!!.status
            txtGenderOfCharacter.text = args.currentResult!!.gender
            txtNameOfCharacter.text = args.currentResult!!.name
            txtLocationOfCharacter.text = args.currentResult!!.locationDomain.name
            Glide.with(imgOfCharacter).load(args.currentResult!!.image).into(imgOfCharacter)
        }
    }

    override fun initListener() {
    }


}