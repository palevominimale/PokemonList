package app.seals.pokemonlist.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonObject
import java.io.Serializable

@Entity(tableName = "Pokemons")
data class PokemonDataModel(
    @PrimaryKey                     var id                     : Int?                  = null,
    @ColumnInfo(name="height"   )   var height                 : Int?                  = null,
    @ColumnInfo(name="name"     )   var name                   : String?               = null,
    @ColumnInfo(name="types"    )   var types                  : ArrayList<JsonObject>     = arrayListOf(),
    @ColumnInfo(name="weight"   )   var weight                 : Int?                  = null,
    @ColumnInfo(name="sprites"  )   var sprites                : SpritesDataModel?   = SpritesDataModel(),
) : Serializable
