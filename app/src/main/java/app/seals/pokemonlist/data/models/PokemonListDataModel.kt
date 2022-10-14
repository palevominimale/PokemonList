package app.seals.pokemonlist.data.models

import com.google.gson.annotations.SerializedName

data class PokemonListDataModel (
    @SerializedName("count"    ) var count    : Int? = null,
    @SerializedName("next"     ) var next     : String? = null,
    @SerializedName("previous" ) var previous : String? = null,
    @SerializedName("results"  ) var results  : ArrayList<PokemonDataModel> = arrayListOf()
)