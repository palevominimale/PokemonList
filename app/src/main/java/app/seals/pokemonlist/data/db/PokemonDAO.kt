package app.seals.pokemonlist.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.seals.pokemonlist.data.models.PokemonDataModel
import app.seals.pokemonlist.data.models.PokemonSmallDataModel

@Dao
interface PokemonDAO {

    @Query("SELECT * FROM Pokemons WHERE id LIKE :id LIMIT 1")
    fun getPokemonByIdData(id: Long) : PokemonDataModel

    @Query("SELECT * FROM PokemonsMini WHERE name LIKE :name LIMIT 1")
    fun getPokemonMiniByName(name: String) : PokemonSmallDataModel

    @Query("SELECT * FROM Pokemons")
    fun getAll() : List<PokemonDataModel>

    @Query("SELECT * FROM PokemonsMini")
    fun getAllMini() : List<PokemonSmallDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPokemon(item: PokemonDataModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPokemonMini(item: PokemonSmallDataModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPokemonMiniList(item: List<PokemonSmallDataModel>)

    @Query("DELETE FROM Pokemons")
    fun clear()

    @Query("DELETE FROM PokemonsMini")
    fun clearMini()
}