package app.seals.pokemonlist.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonSmallDomainModel(
    @SerializedName("name")     val name: String? = null,
    @SerializedName("url")      val url: String? = null
) : Serializable