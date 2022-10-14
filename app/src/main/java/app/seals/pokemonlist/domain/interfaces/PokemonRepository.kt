package app.seals.pokemonlist.domain.interfaces

import app.seals.pokemonlist.domain.models.PokemonDomainModel

interface PokemonRepository {

    fun getPokemonById(id: Long) : PokemonDomainModel

    fun getAll() : List<PokemonDomainModel>

    fun addPokemon(item: PokemonDomainModel)

    fun clear()
}