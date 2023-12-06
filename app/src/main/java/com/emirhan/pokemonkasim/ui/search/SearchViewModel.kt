package com.emirhan.pokemonkasim.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emirhan.pokemonkasim.network.PokemonApiService
import com.emirhan.pokemonkasim.data.PokemonCards
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchViewModel : ViewModel() {

    val _searchResults = MutableLiveData<List<PokemonCards.Data>?>()
    val searchResults: LiveData<List<PokemonCards.Data>?> get() = _searchResults

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.pokemontcg.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(PokemonApiService::class.java)

    fun searchCardsByHealthPoints(hp : Int) {
        val call = apiService.getCardsByHealthPoints(hp)
        call.enqueue(object : Callback<PokemonCards> {
            override fun onResponse(call: Call<PokemonCards>, response: Response<PokemonCards>) {
                if (response.isSuccessful) {
                    val cardsData = response.body()?.data
                    _searchResults.postValue(cardsData as List<PokemonCards.Data>?)
                    Log.d("API_RESPONSE", cardsData.toString())
                } else {
                    Log.e("API_ERROR", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<PokemonCards>, t: Throwable) {
                Log.d("HATA ALDIN", "ON FAILURE")
            }
        })
    }
    fun addToFavorites(card: PokemonCards.Data) {
        card.isFavorite = true

    }
}
