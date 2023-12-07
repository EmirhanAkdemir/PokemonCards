package com.emirhan.pokemonkasim.ui.search

import com.emirhan.pokemonkasim.adapter.SearchAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.emirhan.pokemonkasim.FavoritesViewModelFactory
import com.emirhan.pokemonkasim.R
import com.emirhan.pokemonkasim.data.PokemonCards
import com.emirhan.pokemonkasim.databinding.FragmentSearchBinding
import com.emirhan.pokemonkasim.ui.favorites.FavoritesViewModel

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var progressBar: ProgressBar
    private val viewModel: SearchViewModel by viewModels()
    private val favoritesViewModel: FavoritesViewModel by viewModels { FavoritesViewModelFactory(requireContext().getSharedPreferences("pref_favorites", Context.MODE_PRIVATE)) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progressBar)

        val adapter = SearchAdapter(object : SearchAdapter.OnItemClickListener {
            override fun onItemClick(card: PokemonCards.Data) {
                navigateToCardDetails(card)
            }
        }, object : SearchAdapter.OnItemLongClickListener {
            override fun onItemLongClick(card: PokemonCards.Data) {
                favoritesViewModel.removeFromFavorites(card)
            }
        })

        binding.rvSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSearch.adapter = adapter

        viewModel.searchResults.observe(viewLifecycleOwner) { results ->
            progressBar.visibility = View.GONE
            adapter.submitList(results)
        }

        binding.etSearch.addTextChangedListener { editable ->
            val input = editable.toString()
            if (input.length > 1) {
                progressBar.visibility = View.VISIBLE
                viewModel.searchCardsByHealthPoints(input.toInt())
            }
        }
    }

    private fun navigateToCardDetails(card: PokemonCards.Data) {
        val bundle = Bundle().apply {
            putSerializable("card", card)
        }

        findNavController().navigate(
            R.id.action_searchFragment_to_cardDetailsFragment,
            bundle
        )
    }
}
