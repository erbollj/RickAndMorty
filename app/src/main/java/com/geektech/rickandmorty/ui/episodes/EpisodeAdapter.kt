package com.geektech.rickandmorty.ui.episodes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.rickandmorty.databinding.ItemRecyclerBinding
import com.geektech.rickandmorty.domain.model.CharacterResultDomain
import com.geektech.rickandmorty.domain.model.EpisodeResultDomain
import com.geektech.rickandmorty.domain.model.LocationResultDomain

class EpisodeAdapter(private val list: List<EpisodeResultDomain>): RecyclerView.Adapter<EpisodeAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: EpisodeResultDomain) {
            Glide.with(binding.imgOfCharacter).load("https://variety.com/wp-content/uploads/2017/10/rickandmorty.jpg?w=681&h=383&crop=1").into(binding.imgOfCharacter)
            binding.btnIdNumber.text = position.id.toString()
            binding.txtIsAlive.text = position.created
            binding.txtNameOfCharacter.text = position.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}