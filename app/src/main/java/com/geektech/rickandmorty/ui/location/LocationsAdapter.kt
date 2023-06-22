package com.geektech.rickandmorty.ui.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.rickandmorty.databinding.ItemRecyclerBinding
import com.geektech.rickandmorty.domain.model.LocationResultDomain

class LocationsAdapter :
    PagingDataAdapter<LocationResultDomain, LocationsViewHolder>(ResultDiffUtilCallback) {

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

}

class LocationsViewHolder(private val binding: ItemRecyclerBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: LocationResultDomain?) {
        Glide.with(binding.imgOfCharacter)
            .load("https://static.wikia.nocookie.net/rickandmorty/images/d/d3/Anatomy_Park_7.png/revision/latest?cb=20160913082442")
            .into(binding.imgOfCharacter)
        binding.txtNameOfCharacter.text = item?.name
        binding.btnIdNumber.text = item?.id.toString()
    }

}

private object ResultDiffUtilCallback : DiffUtil.ItemCallback<LocationResultDomain>() {

    override fun areItemsTheSame(
        oldItem: LocationResultDomain,
        newItem: LocationResultDomain
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: LocationResultDomain,
        newItem: LocationResultDomain
    ): Boolean {
        return oldItem == newItem
    }

}

