package com.example.finalspace.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalspace.core.BaseViewHolder
import com.example.finalspace.data.model.character.Characters
import com.example.finalspace.databinding.ItemCharacterBinding

class CharacterAdapter(private val characterList: List<Characters>) :
    RecyclerView.Adapter<BaseViewHolder<Characters>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Characters> {
        val itemBinding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val holder
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: BaseViewHolder<Characters>, position: Int) {
        TODO("Not yet implemented")
    }

private inner class CharacterViewHolder(): BaseViewHolder<Characters>(){
    override fun bind(item: Characters) {
        TODO("Not yet implemented")
    }

}
}