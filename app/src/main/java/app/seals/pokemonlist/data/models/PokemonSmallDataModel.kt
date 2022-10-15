package app.seals.pokemonlist.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "PokemonsMini")
data class PokemonSmallDataModel (
    @PrimaryKey                         val name: String = "",
    @ColumnInfo(name="url")             val url: String? = null
) : Serializable