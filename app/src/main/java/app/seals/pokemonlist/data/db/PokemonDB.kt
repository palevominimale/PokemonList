package app.seals.pokemonlist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.seals.pokemonlist.data.Converters
import app.seals.pokemonlist.data.models.PokemonDataModel

@Database(entities = [PokemonDataModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PokemonDB: RoomDatabase() {

    abstract fun dao(): PokemonDAO

    companion object {
        private var INSTANCE: PokemonDB? = null

        fun getInstance(context: Context): PokemonDB? {
            if (INSTANCE == null) synchronized(PokemonDB::class) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    PokemonDB::class.java,
                    "pokemons.db"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}
