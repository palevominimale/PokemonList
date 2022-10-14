package app.seals.pokemonlist.data.models

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Pokemons")
data class PokemonDataModel(
    @PrimaryKey                     val id: Long = 0L,
    @ColumnInfo(name = "name")      val name: String = "",
    @ColumnInfo(name = "type")      val type: String = "",
    @ColumnInfo(name = "weight")    val weight: Int = 0,
    @ColumnInfo(name = "height")    val height: Int = 0,
    @ColumnInfo(name = "image")     val image: String = ""
) : Serializable
