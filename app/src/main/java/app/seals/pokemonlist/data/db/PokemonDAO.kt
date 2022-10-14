package app.seals.pokemonlist.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.seals.pokemonlist.data.models.PokemonDataModel

@Dao
interface PokemonDAO {

    @Query("SELECT * FROM Pokemons WHERE id LIKE :id LIMIT 1")
    fun getPokemonByIdData(id: Long) : PokemonDataModel

    @Query("SELECT * FROM Pokemons")
    fun getAll() : List<PokemonDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPokemon(item: PokemonDataModel)

    @Query("DELETE FROM Pokemons")
    fun clear()
}