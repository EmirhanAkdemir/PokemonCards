package com.emirhan.pokemonkasim/* package com.emirhan.pokemonkasim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.emirhan.pokemonkasim.databinding.FragmentCardDetailsBinding

class CardDetailsFragment : Fragment() {

    private lateinit var binding : FragmentCardDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCardDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardName = requireArguments().getString(ARG_CARD_NAME)
        val cardArtist = requireArguments().getString(ARG_CARD_ARTIST)
        val card = 
        binding.tvCardName.text = cardName
        binding.tvCardArtist.text = cardArtist

        Glide.with(this)
            .load(card.images?.large)
            .placeholder(R.drawable.placeholder_image)
            .into(binding.ivCardImage)
    }

    companion object {
        const val ARG_CARD_NAME = "card_name"
        const val ARG_CARD_ARTIST = "card_artist"

        fun newInstance(cardName: String, cardArtist: String): CardDetailsFragment {
            val fragment = CardDetailsFragment()
            val args = Bundle()
            args.putString(ARG_CARD_NAME, cardName)
            args.putString(ARG_CARD_ARTIST, cardArtist)
            fragment.arguments = args
            return fragment
        }
    }
}*/