package app.seals.pokemonlist.network

import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.domain.models.PokemonSmallDomainModel
import app.seals.pokemonlist.network.models.PokemonNetworkModel
import app.seals.pokemonlist.network.models.PokemonSmallNetworkModel

fun PokemonNetworkModel.mapToDomain() : PokemonDomainModel {
    return PokemonDomainModel(
        height, id, name, types, weight, sprites
    )
}

fun PokemonSmallNetworkModel.mapToDomain() : PokemonSmallDomainModel {
    return PokemonSmallDomainModel(name, url)
}