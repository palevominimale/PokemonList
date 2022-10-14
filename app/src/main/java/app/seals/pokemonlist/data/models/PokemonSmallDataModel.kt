package app.seals.pokemonlist.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonSmallDataModel (
    @SerializedName("name")     val name: String? = null,
    @SerializedName("url")      val url: String? = null
) : Serializable