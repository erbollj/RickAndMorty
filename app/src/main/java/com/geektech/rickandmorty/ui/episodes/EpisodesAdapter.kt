package com.geektech.rickandmorty.ui.episodes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.rickandmorty.databinding.ItemRecyclerBinding
import com.geektech.rickandmorty.domain.model.CharacterResultDomain
import com.geektech.rickandmorty.domain.model.EpisodeResultDomain

class EpisodesAdapter: PagingDataAdapter<EpisodeResultDomain, EpisodesViewHolder>(ResultDiffUtilCallback) {
    
    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        return EpisodesViewHolder(ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }
}

class EpisodesViewHolder(private val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: EpisodeResultDomain?) {
        Glide.with(binding.imgOfCharacter).load("https://variety.com/wp-content/uploads/2017/10/rickandmorty.jpg?w=681&h=383&crop=1").into(binding.imgOfCharacter)
        binding.btnIdNumber.text = item?.id.toString()
        binding.txtIsAlive.text = item?.created
        binding.txtNameOfCharacter.text = item?.name
    }

}

private object ResultDiffUtilCallback: DiffUtil.ItemCallback<EpisodeResultDomain>() {
    override fun areItemsTheSame(
        oldItem: EpisodeResultDomain,
        newItem: EpisodeResultDomain
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: EpisodeResultDomain,
        newItem: EpisodeResultDomain
    ): Boolean {
        return oldItem == newItem
    }

}

