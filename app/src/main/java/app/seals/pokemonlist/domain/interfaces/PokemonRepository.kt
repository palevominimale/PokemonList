package app.seals.pokemonlist.domain.interfaces

import app.seals.pokemonlist.data.db.PokemonDAO
import app.seals.pokemonlist.data.models.PokemonDataModel
import app.seals.pokemonlist.domain.models.PokemonDomainModel

interface PokemonRepository : PokemonDAO {

    override fun getPokemonByIdData(id: Long) : PokemonDataModel
    fun getPokemonById(id: Long) : PokemonDomainModel

    override fun getAll() : List<PokemonDataModel>
    fun getAllDomain() : List<PokemonDomainModel>

    override fun addPokemon(item: PokemonDataModel)
    fun addPokemon(item: PokemonDomainModel)

    override fun clear()
}