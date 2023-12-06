package com.emirhan.pokemonkasim

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emirhan.pokemonkasim.data.PokemonCards

class CardDetailsViewModel : ViewModel() {

    private val _cardDetails = MutableLiveData<PokemonCards.Data>()
    val cardDetails : LiveData<PokemonCards.Data> get() = _cardDetails

    fun setCardDetails(card : PokemonCards.Data) {
        _cardDetails.value = card
    }
}