package com.geektech.rickandmorty.ui.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.databinding.ItemRecyclerBinding
import com.geektech.rickandmorty.domain.model.CharacterResultDomain

class CharactersAdapter :
    PagingDataAdapter<CharacterResultDomain, ResultViewHolder>(ResultDiffUtilCallback) {
    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(
            ItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}

class ResultViewHolder(private val binding: ItemRecyclerBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: CharacterResultDomain) {
        Glide.with(binding.imgOfCharacter).load(position.image).into(binding.imgOfCharacter)
        binding.btnIdNumber.text = position.id.toString()
        binding.txtIsAlive.text = position.status
        binding.txtNameOfCharacter.text = position.name
        itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("result", position)
            it.findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
        }
    }
}

private object ResultDiffUtilCallback : DiffUtil.ItemCallback<CharacterResultDomain>() {
    override fun areItemsTheSame(
        oldItem: CharacterResultDomain,
        newItem: CharacterResultDomain
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CharacterResultDomain,
        newItem: CharacterResultDomain
    ): Boolean {
        return oldItem == newItem
    }

}
