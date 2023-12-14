package com.example.rickandmortyapp.ui.List.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.databinding.ItemCharacterBinding
import com.example.rickandmortyapp.data.network.response.Result

class CharacterListViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterBinding.bind(itemView)
    fun render(character: Result, onItemSelected: (Result) -> Unit) {
        binding.tvCharacterTitle.text = character.name
        Glide.with(binding.ivCharacter)
            .load(character.image)
            .into(binding.ivCharacter)

        binding.root.setOnClickListener {
            onItemSelected(character)
        }
    }
}