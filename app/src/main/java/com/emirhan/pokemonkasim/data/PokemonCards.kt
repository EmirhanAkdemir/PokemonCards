package com.emirhan.pokemonkasim.data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonCards(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("data")
    val `data`: List<Data?>?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("pageSize")
    val pageSize: Int?,
    @SerializedName("totalCount")
    val totalCount: Int?
) {
    data class Data(
        @SerializedName("abilities")
        val abilities: List<Ability?>?,
        @SerializedName("artist")
        val artist: String?,
        @SerializedName("attacks")
        val attacks: List<Attack?>?,
        @SerializedName("cardmarket")
        val cardmarket: Cardmarket?,
        @SerializedName("convertedRetreatCost")
        val convertedRetreatCost: Int?,
        @SerializedName("evolvesFrom")
        val evolvesFrom: String?,
        @SerializedName("evolvesTo")
        val evolvesTo: List<String?>?,
        @SerializedName("flavorText")
        val flavorText: String?,
        @SerializedName("hp")
        val hp: String?,
        @SerializedName("id")
        val id: String?,
        @SerializedName("images")
        val images: İmages?,
        @SerializedName("legalities")
        val legalities: Legalities?,
        @SerializedName("level")
        val level: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("nationalPokedexNumbers")
        val nationalPokedexNumbers: List<Int?>?,
        @SerializedName("number")
        val number: String?,
        @SerializedName("rarity")
        val rarity: String?,
        @SerializedName("regulationMark")
        val regulationMark: String?,
        @SerializedName("resistances")
        val resistances: List<Resistance?>?,
        @SerializedName("retreatCost")
        val retreatCost: List<String?>?,
        @SerializedName("rules")
        val rules: List<String?>?,
        @SerializedName("set")
        val `set`: Set?,
        @SerializedName("subtypes")
        val subtypes: List<String?>?,
        @SerializedName("supertype")
        val supertype: String?,
        @SerializedName("tcgplayer")
        val tcgplayer: Tcgplayer?,
        @SerializedName("types")
        val types: List<String?>?,
        @SerializedName("weaknesses")
        val weaknesses: List<Weaknesse?>?,
        var isFavorite: Boolean? = false
    ) : Serializable {
        data class Ability(
            @SerializedName("name")
            val name: String?,
            @SerializedName("text")
            val text: String?,
            @SerializedName("type")
            val type: String?
        )

        data class Attack(
            @SerializedName("convertedEnergyCost")
            val convertedEnergyCost: Int?,
            @SerializedName("cost")
            val cost: List<String?>?,
            @SerializedName("damage")
            val damage: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("text")
            val text: String?
        )

        data class Cardmarket(
            @SerializedName("prices")
            val prices: Prices?,
            @SerializedName("updatedAt")
            val updatedAt: String?,
            @SerializedName("url")
            val url: String?
        ) {
            data class Prices(
                @SerializedName("averageSellPrice")
                val averageSellPrice: Double?,
                @SerializedName("avg1")
                val avg1: Double?,
                @SerializedName("avg30")
                val avg30: Double?,
                @SerializedName("avg7")
                val avg7: Double?,
                @SerializedName("germanProLow")
                val germanProLow: Double?,
                @SerializedName("lowPrice")
                val lowPrice: Double?,
                @SerializedName("lowPriceExPlus")
                val lowPriceExPlus: Double?,
                @SerializedName("reverseHoloAvg1")
                val reverseHoloAvg1: Double?,
                @SerializedName("reverseHoloAvg30")
                val reverseHoloAvg30: Double?,
                @SerializedName("reverseHoloAvg7")
                val reverseHoloAvg7: Double?,
                @SerializedName("reverseHoloLow")
                val reverseHoloLow: Double?,
                @SerializedName("reverseHoloSell")
                val reverseHoloSell: Double?,
                @SerializedName("reverseHoloTrend")
                val reverseHoloTrend: Double?,
                @SerializedName("suggestedPrice")
                val suggestedPrice: Double?,
                @SerializedName("trendPrice")
                val trendPrice: Double?
            )
        }

        data class İmages(
            @SerializedName("large")
            val large: String?,
            @SerializedName("small")
            val small: String?
        )

        data class Legalities(
            @SerializedName("expanded")
            val expanded: String?,
            @SerializedName("unlimited")
            val unlimited: String?
        )

        data class Resistance(
            @SerializedName("type")
            val type: String?,
            @SerializedName("value")
            val value: String?
        )

        data class Set(
            @SerializedName("id")
            val id: String?,
            @SerializedName("images")
            val images: İmages?,
            @SerializedName("legalities")
            val legalities: Legalities?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("printedTotal")
            val printedTotal: Int?,
            @SerializedName("ptcgoCode")
            val ptcgoCode: String?,
            @SerializedName("releaseDate")
            val releaseDate: String?,
            @SerializedName("series")
            val series: String?,
            @SerializedName("total")
            val total: Int?,
            @SerializedName("updatedAt")
            val updatedAt: String?
        ) {
            data class İmages(
                @SerializedName("logo")
                val logo: String?,
                @SerializedName("symbol")
                val symbol: String?
            )

            data class Legalities(
                @SerializedName("expanded")
                val expanded: String?,
                @SerializedName("unlimited")
                val unlimited: String?
            )
        }

        data class Tcgplayer(
            @SerializedName("prices")
            val prices: Prices?,
            @SerializedName("updatedAt")
            val updatedAt: String?,
            @SerializedName("url")
            val url: String?
        ) {
            data class Prices(
                @SerializedName("holofoil")
                val holofoil: Holofoil?,
                @SerializedName("normal")
                val normal: Normal?,
                @SerializedName("reverseHolofoil")
                val reverseHolofoil: ReverseHolofoil?,
                @SerializedName("1stEditionHolofoil")
                val stEditionHolofoil: StEditionHolofoil?,
                @SerializedName("unlimitedHolofoil")
                val unlimitedHolofoil: UnlimitedHolofoil?
            ) {
                data class Holofoil(
                    @SerializedName("directLow")
                    val directLow: Double?,
                    @SerializedName("high")
                    val high: Double?,
                    @SerializedName("low")
                    val low: Double?,
                    @SerializedName("market")
                    val market: Double?,
                    @SerializedName("mid")
                    val mid: Double?
                )

                data class Normal(
                    @SerializedName("directLow")
                    val directLow: Double?,
                    @SerializedName("high")
                    val high: Double?,
                    @SerializedName("low")
                    val low: Double?,
                    @SerializedName("market")
                    val market: Double?,
                    @SerializedName("mid")
                    val mid: Double?
                )

                data class ReverseHolofoil(
                    @SerializedName("directLow")
                    val directLow: Double?,
                    @SerializedName("high")
                    val high: Double?,
                    @SerializedName("low")
                    val low: Double?,
                    @SerializedName("market")
                    val market: Double?,
                    @SerializedName("mid")
                    val mid: Double?
                )

                data class StEditionHolofoil(
                    @SerializedName("directLow")
                    val directLow: Double?,
                    @SerializedName("high")
                    val high: Double?,
                    @SerializedName("low")
                    val low: Double?,
                    @SerializedName("market")
                    val market: Double?,
                    @SerializedName("mid")
                    val mid: Double?
                )

                data class UnlimitedHolofoil(
                    @SerializedName("directLow")
                    val directLow: Double?,
                    @SerializedName("high")
                    val high: Double?,
                    @SerializedName("low")
                    val low: Double?,
                    @SerializedName("market")
                    val market: Double?,
                    @SerializedName("mid")
                    val mid: Double?
                )
            }
        }

        data class Weaknesse(
            @SerializedName("type")
            val type: String?,
            @SerializedName("value")
            val value: String?
        )
    }
}