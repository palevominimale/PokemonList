package app.seals.pokemonlist.network.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonSmallNetworkModel (
    @SerializedName("name")     val name: String? = null,
    @SerializedName("url")      val url: String? = null
) : Serializable