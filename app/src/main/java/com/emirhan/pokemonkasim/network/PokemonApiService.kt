package com.emirhan.pokemonkasim.network

import com.emirhan.pokemonkasim.data.PokemonCards
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {
    @GET("v2/cards")
    fun getCardsByHealthPoints(
        @Query("hp")
        hp : Int
    ) : Call<PokemonCards>
}