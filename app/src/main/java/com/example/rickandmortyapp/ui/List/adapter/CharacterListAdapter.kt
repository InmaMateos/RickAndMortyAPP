package com.example.rickandmortyapp.ui.List.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.network.response.Result

class CharacterListAdapter (
    private var characterList: List<Result>,
    private val onItemSelected:(Result) -> Unit)
    : RecyclerView.Adapter<CharacterListViewHolder>() {

    fun updateList(characterList: List<Result>){
       this.characterList = characterList
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        return CharacterListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
       holder.render(characterList[position], onItemSelected)
    }

    override fun getItemCount(): Int = characterList.size

}