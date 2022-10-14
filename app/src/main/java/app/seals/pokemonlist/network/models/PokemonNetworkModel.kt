package app.seals.pokemonlist.network.models

import app.seals.pokemonlist.domain.models.SpritesDomainModel
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class PokemonNetworkModel (
    @SerializedName("height"                   ) var height                 : Int?                  = null,
    @SerializedName("id"                       ) var id                     : Int?                  = null,
    @SerializedName("name"                     ) var name                   : String?               = null,
    @SerializedName("types"                    ) var types                  : ArrayList<JsonObject>     = arrayListOf(),
    @SerializedName("weight"                   ) var weight                 : Int?                  = null,
    @SerializedName("sprites"                  ) var sprites                : SpritesDomainModel?   = SpritesDomainModel(),

    @SerializedName("abilities"                ) var abilities              : ArrayList<JsonObject>   = arrayListOf(),
    @SerializedName("base_experience"          ) var baseExperience         : Int?                   = null,
    @SerializedName("forms"                    ) var forms                  : ArrayList<JsonObject>       = arrayListOf(),
    @SerializedName("game_indices"             ) var gameIndices            : ArrayList<JsonObject> = arrayListOf(),
    @SerializedName("held_items"               ) var heldItems              : ArrayList<JsonObject>      = arrayListOf(),
    @SerializedName("is_default"               ) var isDefault              : Boolean?               = null,
    @SerializedName("location_area_encounters" ) var locationAreaEncounters : String?                = null,
    @SerializedName("moves"                    ) var moves                  : ArrayList<JsonObject>       = arrayListOf(),
    @SerializedName("order"                    ) var order                  : Int?                   = null,
    @SerializedName("past_types"               ) var pastTypes              : ArrayList<JsonObject>      = arrayListOf(),
    @SerializedName("species"                  ) var species                : JsonObject?               = JsonObject(),
    @SerializedName("stats"                    ) var stats                  : ArrayList<JsonObject>       = arrayListOf(),
)