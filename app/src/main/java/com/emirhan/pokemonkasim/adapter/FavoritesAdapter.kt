package com.emirhan.pokemonkasim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emirhan.pokemonkasim.R
import com.emirhan.pokemonkasim.data.PokemonCards.Data
import com.emirhan.pokemonkasim.databinding.ItemCardBinding

class FavoritesAdapter(private val itemClickListener: OnItemClickListener) :
    ListAdapter<Data, FavoritesAdapter.CardViewHolder>(DiffCallback()) {

    private var favoriteCards: List<Data> = emptyList()

    fun updateFavoriteCards(cards: List<Data>) {
        favoriteCards = cards
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding =
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = getItem(position)
        holder.bind(card)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(card)
        }

        holder.itemView.setOnLongClickListener {
            itemClickListener.onItemLongClick(card)
            true
        }
    }

    inner class CardViewHolder(
        private val binding: ItemCardBinding,
        private val itemClickListener: OnItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Data) {
            binding.apply {
                tvCardName.text = card.name
                tvHealthPoints.text = "Health Points: ${card.hp}"

                Glide.with(itemView.context)
                    .load(card.images?.large)
                    .placeholder(R.drawable.placeholder_image)
                    .into(ivCard)

                itemView.setOnClickListener {
                    itemClickListener.onItemClick(card)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(card: Data)
        fun onItemLongClick(card: Data)
    }

    private class DiffCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}
