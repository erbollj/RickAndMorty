package com.geektech.rickandmorty.ui.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.rickandmorty.databinding.ItemRecyclerBinding
import com.geektech.rickandmorty.domain.model.CharacterResultDomain

class CharacterAdapter(private val list: List<CharacterResultDomain>): RecyclerView.Adapter<CharacterAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: CharacterResultDomain) {
            Glide.with(binding.imgOfCharacter).load(position.image).into(binding.imgOfCharacter)
            binding.btnIdNumber.text = position.id.toString()
            binding.txtIsAlive.text = position.status
            binding.txtNameOfCharacter.text = position.name
            itemView.setOnClickListener {
                val action = CharacterFragmentDirections.actionCharacterFragmentToDetailFragment(position)
                it.findNavController().navigate(action)
            }
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