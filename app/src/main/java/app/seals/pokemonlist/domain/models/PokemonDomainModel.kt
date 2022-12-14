package app.seals.pokemonlist.domain.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class PokemonDomainModel (
    @SerializedName("height"                   ) var height                 : Int?                  = null,
    @SerializedName("id"                       ) var id                     : Int?                  = null,
    @SerializedName("name"                     ) var name                   : String?               = null,
    @SerializedName("types"                    ) var types                  : ArrayList<JsonObject> = arrayListOf(),
    @SerializedName("weight"                   ) var weight                 : Int?                  = null,
    @SerializedName("sprites"                  ) var sprites                : SpritesDomainModel?   = SpritesDomainModel(),
    @SerializedName("url"                      ) var url                    : String?               = null
)