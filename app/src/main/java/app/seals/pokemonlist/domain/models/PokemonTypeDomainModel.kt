package app.seals.pokemonlist.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonTypeDomainModel (
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
) : Serializable