package app.seals.pokemonlist.domain.interfaces

import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.domain.models.PokemonListDomainModel

interface ApiGetData {
    suspend fun invoke() : PokemonListDomainModel?
    suspend fun invoke(id: Int) : PokemonDomainModel?
}