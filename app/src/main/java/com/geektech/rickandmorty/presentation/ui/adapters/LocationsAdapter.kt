package com.geektech.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.rickandmorty.databinding.ItemRecyclerBinding
import com.geektech.rickandmorty.presentation.models.LocationResultUI

class LocationsAdapter :
    PagingDataAdapter<LocationResultUI, LocationsViewHolder>(ResultDiffUtilCallback) {

    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder {
        return LocationsViewHolder(
            ItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    private object ResultDiffUtilCallback : DiffUtil.ItemCallback<LocationResultUI>() {
        override fun areItemsTheSame(
            oldItem: LocationResultUI,
            newItem: LocationResultUI
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: LocationResultUI,
            newItem: LocationResultUI
        ): Boolean {
            return oldItem == newItem
        }

    }

}

class LocationsViewHolder(private val binding: ItemRecyclerBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: LocationResultUI?) {
        Glide.with(binding.imgOfCharacter)
            .load("https://static.wikia.nocookie.net/rickandmorty/images/d/d3/Anatomy_Park_7.png/revision/latest?cb=20160913082442")
            .into(binding.imgOfCharacter)
        binding.txtNameOfCharacter.text = item?.name
        binding.btnIdNumber.text = item?.id.toString()
    }

}



