package app.seals.pokemonlist.network

import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.network.models.PokemonNetworkModel

fun PokemonNetworkModel.mapToDomain() : PokemonDomainModel {
    return PokemonDomainModel(
        height, id, name, types, weight, sprites
    )
}