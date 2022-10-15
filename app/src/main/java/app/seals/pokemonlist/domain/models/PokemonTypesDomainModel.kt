package app.seals.pokemonlist.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonTypesDomainModel (

    @SerializedName("slot" ) var slot : Int?  = null,
    @SerializedName("type" ) var type : PokemonTypeDomainModel? = PokemonTypeDomainModel()

) : Serializable