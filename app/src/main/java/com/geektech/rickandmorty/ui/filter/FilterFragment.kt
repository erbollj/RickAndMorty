package com.geektech.rickandmorty.ui.filter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.core.BaseBottomFragment
import com.geektech.rickandmorty.databinding.FragmentFilterBinding

class FilterFragment : BaseBottomFragment<FragmentFilterBinding, FilterViewModel>() {

    override val viewModel: FilterViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentFilterBinding {
        return FragmentFilterBinding.inflate(inflater, container, false)
    }

    override fun initView() {

    }

    @SuppressLint("ResourceAsColor")
    override fun initListener() {

        val mainBundle = Bundle()
        val bundleStatus = Bundle()
        val bundleGender = Bundle()
        mainBundle.putBundle("bundleStatus", bundleStatus)
        mainBundle.putBundle("bundleGender", bundleGender)

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rBtnAlive -> {
                    bundleStatus.putString("key1", "alive")
                }
                R.id.rBtnDead -> {
                    bundleStatus.putString("key1", "dead")
                }
                else -> {
                    bundleStatus.putString("key1", "unknown")
                }
            }
        }

        binding.radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rBtnMale -> {
                    bundleGender.putString("key2", "male")
                }
                R.id.rBtnFemale -> {
                    bundleGender.putString("key2", "female")
                }
                R.id.rBtnGenderUnknown -> {
                    bundleGender.putString("key2", "unknown")
                }
                R.id.rBtnGenderless -> {
                    bundleGender.putString("key2", "genderless")
                }
            }
        }

        binding.txtClear.setOnClickListener {
            binding.radioGroup.clearCheck()
            binding.radioGroup2.clearCheck()
        }

        binding.btnApply.setOnClickListener {
            findNavController().navigate(R.id.action_filterFragment_to_listFragment, mainBundle)
        }
    }

}

