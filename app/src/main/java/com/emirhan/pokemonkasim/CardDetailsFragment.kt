package com.emirhan.pokemonkasim

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.emirhan.pokemonkasim.data.PokemonCards
import com.emirhan.pokemonkasim.databinding.FragmentCardDetailsBinding
import com.emirhan.pokemonkasim.ui.favorites.FavoritesViewModel

class CardDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCardDetailsBinding
    private val viewModel : CardDetailsViewModel by viewModels()
    private val favoritesViewModel : FavoritesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeCardDetails()

        arguments?.let {
            val card = it.getSerializable("card") as? PokemonCards.Data
            card?.let { nonNullCard ->
                viewModel.setCardDetails(nonNullCard)
            }
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.root.setOnLongClickListener {
            addToFavorites()
            true
        }

        favoritesViewModel.favoriteCards.observe(viewLifecycleOwner) { favoriteCards ->

        }
    }

    private fun addToFavorites() {
        val card = viewModel.cardDetails.value
        card?.let {
            favoritesViewModel.addToFavorites(it)
        }
        Toast.makeText(requireContext(), "Card added to favorites", Toast.LENGTH_SHORT).show()
    }

    private fun observeCardDetails() {
        viewModel.cardDetails.observe(viewLifecycleOwner, Observer { card ->
            binding.tvCardName.text = card.name
            binding.tvArtistName.text = card.artist

            Glide.with(requireContext())
                .load(card.images?.large)
                .placeholder(R.drawable.placeholder_image)
                .into(binding.ivCardImage)
        })
    }

}
