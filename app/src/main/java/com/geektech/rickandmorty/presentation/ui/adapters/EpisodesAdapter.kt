package com.geektech.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.rickandmorty.databinding.ItemRecyclerBinding
import com.geektech.rickandmorty.presentation.models.EpisodeResultUI

class EpisodesAdapter :
    PagingDataAdapter<EpisodeResultUI, EpisodesViewHolder>(ResultDiffUtilCallback) {

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        return EpisodesViewHolder(
            ItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private object ResultDiffUtilCallback : DiffUtil.ItemCallback<EpisodeResultUI>() {
        override fun areItemsTheSame(oldItem: EpisodeResultUI, newItem: EpisodeResultUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EpisodeResultUI,
            newItem: EpisodeResultUI
        ): Boolean {
            return oldItem == newItem
        }

    }

}

class EpisodesViewHolder(private val binding: ItemRecyclerBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: EpisodeResultUI?) {
        Glide.with(binding.imgOfCharacter)
            .load("https://variety.com/wp-content/uploads/2017/10/rickandmorty.jpg?w=681&h=383&crop=1")
            .into(binding.imgOfCharacter)
        binding.btnIdNumber.text = item?.id.toString()
        binding.txtNameOfCharacter.text = item?.name
    }

}



