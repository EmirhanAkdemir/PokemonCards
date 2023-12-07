package com.emirhan.pokemonkasim.ui.favorites

import com.emirhan.pokemonkasim.adapter.FavoritesAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.emirhan.pokemonkasim.FavoritesViewModelFactory
import com.emirhan.pokemonkasim.data.PokemonCards
import com.emirhan.pokemonkasim.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private val favoritesViewModel: FavoritesViewModel by viewModels { FavoritesViewModelFactory(requireContext().getSharedPreferences("pref_favorites", Context.MODE_PRIVATE)) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = FavoritesAdapter(object : FavoritesAdapter.OnItemClickListener {
            override fun onItemClick(card: PokemonCards.Data) {

            }

            override fun onItemLongClick(card: PokemonCards.Data) {
                favoritesViewModel.removeFromFavorites(card)
            }
        })

        binding.rvFavorites.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavorites.adapter = adapter

        favoritesViewModel.favoriteCards.observe(viewLifecycleOwner) { favoriteCards ->
            adapter.submitList(favoriteCards)
        }
    }
}
