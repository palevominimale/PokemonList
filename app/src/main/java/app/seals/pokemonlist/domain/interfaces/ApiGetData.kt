package app.seals.pokemonlist.domain.interfaces

import app.seals.pokemonlist.domain.models.PokemonListDomainModel

interface ApiGetData {
    suspend fun invoke() : PokemonListDomainModel
}