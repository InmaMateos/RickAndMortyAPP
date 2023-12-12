package com.example.rickandmortyapp.ui.List.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.databinding.ItemCharacterBinding
import com.example.rickandmortyapp.network.response.Result

class CharacterListViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterBinding.bind(itemView)
    fun render(character: Result){
        binding.tvCharacterTitle.text = character.name
        Glide.with(binding.ivCharacter)
            .load(character.image)
            .into(binding.ivCharacter)
    }
}