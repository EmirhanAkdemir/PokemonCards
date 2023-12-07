package com.emirhan.pokemonkasim.ui.favorites

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emirhan.pokemonkasim.data.PokemonCards
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class FavoritesViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {

    private val _favoriteCards = MutableLiveData<List<PokemonCards.Data>>()
    val favoriteCards: LiveData<List<PokemonCards.Data>> get() = _favoriteCards

    companion object {
        private const val PREF_KEY_FAVORITES = "pref_key_favorites"
    }

    init {
        val favoritesJson = sharedPreferences.getString(PREF_KEY_FAVORITES, null)
        val favoritesList = favoritesJson?.let {
            Gson().fromJson<List<PokemonCards.Data>>(
                it,
                object : TypeToken<List<PokemonCards.Data>>() {}.type
            )
        } ?: emptyList()

        _favoriteCards.postValue(favoritesList)
    }


    private fun saveFavoritesToSharedPreferences(favoritesList: List<PokemonCards.Data>) {
        val editor = sharedPreferences.edit()
        val favoritesJson = Gson().toJson(favoritesList)
        editor.putString(PREF_KEY_FAVORITES, favoritesJson)
        editor.apply()
    }

    fun addToFavorites(card: PokemonCards.Data) {
        val currentList = _favoriteCards.value.orEmpty().toMutableList()
        if (!currentList.contains(card)) {
            currentList.add(card)
            _favoriteCards.value = currentList
            saveFavoritesToSharedPreferences(currentList)
        }
    }

    fun removeFromFavorites(card: PokemonCards.Data) {
        val currentList = _favoriteCards.value.orEmpty().toMutableList()
        currentList.remove(card)
        _favoriteCards.value = currentList
        saveFavoritesToSharedPreferences(currentList)
    }
}
