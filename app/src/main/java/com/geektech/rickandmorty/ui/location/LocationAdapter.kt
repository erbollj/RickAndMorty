package com.geektech.rickandmorty.ui.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.rickandmorty.databinding.ItemRecyclerBinding
import com.geektech.rickandmorty.domain.model.CharacterResultDomain
import com.geektech.rickandmorty.domain.model.LocationResultDomain

class LocationAdapter(private val list: List<LocationResultDomain>): RecyclerView.Adapter<LocationAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: LocationResultDomain) {
            Glide.with(binding.imgOfCharacter).load("https://static.wikia.nocookie.net/rickandmorty/images/d/d3/Anatomy_Park_7.png/revision/latest?cb=20160913082442").into(binding.imgOfCharacter)
            binding.btnIdNumber.text = position.id.toString()
            binding.txtIsAlive.text = position.type
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