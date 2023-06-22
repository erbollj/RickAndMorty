package com.geektech.rickandmorty.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.core.BaseBottomFragment
import com.geektech.rickandmorty.databinding.FragmentFilterBinding
import com.geektech.rickandmorty.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilterFragment : BaseBottomFragment<FragmentFilterBinding, FilterViewModel>() {

    override val viewModel: FilterViewModel by viewModel()
    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentFilterBinding {
        return FragmentFilterBinding.inflate(inflater, container, false)
    }

    override fun initView() {

    }

    override fun initListener() {

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rBtnAlive -> {
                    sharedViewModel.getCharactersWithStatus("Alive")
                }

                R.id.rBtnDead -> {
                    sharedViewModel.getCharactersWithStatus("Dead")
                }

                else -> {
                    sharedViewModel.getCharactersWithStatus("unknown")
                }
            }
        }

        binding.radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rBtnMale -> {
                    sharedViewModel.getCharactersWithGender("Male")
                }

                R.id.rBtnFemale -> {
                    sharedViewModel.getCharactersWithGender("Female")
                }

                R.id.rBtnGenderUnknown -> {
                    sharedViewModel.getCharactersWithGender("unknown")
                }

                R.id.rBtnGenderless -> {
                    sharedViewModel.getCharactersWithGender("Male")
                }
            }
        }

        binding.txtClear.setOnClickListener {
            binding.radioGroup.clearCheck()
            binding.radioGroup2.clearCheck()
            sharedViewModel.getCharactersWithGender(null)
            sharedViewModel.getCharactersWithStatus(null)
        }

        binding.btnApply.setOnClickListener {
            findNavController().navigateUp()
        }

    }

}

