package app.seals.pokemonlist.network.models

import com.google.gson.annotations.SerializedName

data class PokemonNetworkModel (
    @SerializedName("height"                   ) var height                 : Int?                   = null,
    @SerializedName("id"                       ) var id                     : Int?                   = null,
    @SerializedName("name"                     ) var name                   : String?                = null,
    @SerializedName("types"                    ) var types                  : ArrayList<String>       = arrayListOf(),
    @SerializedName("weight"                   ) var weight                 : Int?                   = null,
    @SerializedName("sprites"                  ) var sprites                : SpritesNetworkModel?               = SpritesNetworkModel(),
)