package app.seals.pokemonlist.domain.interfaces

import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.domain.models.PokemonSmallDomainModel

interface PokemonRepository {

    fun getPokemonById(id: Long) : PokemonDomainModel
    fun getPokemonMiniByName(name: String) : PokemonSmallDomainModel

    fun getAll() : List<PokemonDomainModel>
    fun getAllMini() : List<PokemonSmallDomainModel>

    fun addPokemon(item: PokemonDomainModel)
    fun addPokemonMini(item: PokemonSmallDomainModel)
    fun addPokemonMiniList(item: List<PokemonSmallDomainModel>)

    fun clear()
    fun clearMini()
}