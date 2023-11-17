package com.example.finalspace.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalspace.R
import com.example.finalspace.core.BaseViewHolder
import com.example.finalspace.data.model.character.Character
import com.example.finalspace.databinding.ItemCharacterBinding


class CharacterAdapter(private var characterList: List<Character> = listOf()) :
    RecyclerView.Adapter<BaseViewHolder<Character>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Character> {
        val itemBinding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)


        return CharacterViewHolder(itemBinding, parent.context)
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: BaseViewHolder<Character>, position: Int) {
        val item = characterList[position]
        when (holder) {
            is CharacterViewHolder -> holder.bind(item)
        }
    }

    private inner class CharacterViewHolder(private val binding: ItemCharacterBinding ,private val context: Context) :
        BaseViewHolder<Character>(binding.root) {

        override fun bind(item: Character) {
            Glide.with(binding.root).load(item.img_url).centerCrop()
                .into(binding.imgCharacter)

            binding.name.text = context.getString(R.string.name,item.name)
            binding.hair.text = context.getString(R.string.hair,item.hair)
            binding.gender.text = context.getString(R.string.gender,item.gender)
            binding.origin.text = context.getString(R.string.origin,item.origin)
            binding.status.text = context.getString(R.string.status,item.status)
            binding.species.text = context.getString(R.string.specie,item.species)
        }

    }

    fun setData(newData: List<Character>) {
        val diffCallback = WeatherDiffCallback(characterList, newData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        characterList = newData
        diffResult.dispatchUpdatesTo(this)

    }
}