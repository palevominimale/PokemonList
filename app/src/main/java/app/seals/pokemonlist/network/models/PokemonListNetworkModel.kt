package app.seals.pokemonlist.network.models

import com.google.gson.annotations.SerializedName

data class PokemonListNetworkModel (
    @SerializedName("count"    ) var count    : Int? = null,
    @SerializedName("next"     ) var next     : String? = null,
    @SerializedName("previous" ) var previous : String? = null,
    @SerializedName("results"  ) var results  : ArrayList<PokemonSmallNetworkModel> = arrayListOf()
)