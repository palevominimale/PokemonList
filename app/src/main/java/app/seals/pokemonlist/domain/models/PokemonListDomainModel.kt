package app.seals.pokemonlist.domain.models

import com.google.gson.annotations.SerializedName

data class PokemonListDomainModel (
    @SerializedName("count"    ) var count    : Int? = null,
    @SerializedName("next"     ) var next     : String? = null,
    @SerializedName("previous" ) var previous : String? = null,
    @SerializedName("results"  ) var results  : ArrayList<PokemonSmallDomainModel> = arrayListOf()
)