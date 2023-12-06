package com.emirhan.pokemonkasim.ui.favorites

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emirhan.pokemonkasim.data.PokemonCards

class FavoritesViewModel() : ViewModel() {

    private val _favoriteCards = MutableLiveData<List<PokemonCards.Data>>()
    val favoriteCards : LiveData<List<PokemonCards.Data>> get() = _favoriteCards

    fun addToFavorites(card : PokemonCards.Data) {
        val currentList = _favoriteCards.value.orEmpty().toMutableList()
        currentList.add(card)
        _favoriteCards.value = currentList
    }





}