package app.seals.pokemonlist.data

import app.seals.pokemonlist.data.models.PokemonDataModel
import app.seals.pokemonlist.domain.models.PokemonDomainModel

fun PokemonDataModel.mapToDomain() : PokemonDomainModel {
    return PokemonDomainModel(
        id = this.id,
        name = this.name,
        type = this.type,
        weight = this.weight,
        height = this.height,
        image = this.image
    )
}

fun PokemonDomainModel.mapToData() : PokemonDataModel {
    return PokemonDataModel(
        id = this.id,
        name = this.name,
        type = this.type,
        weight = this.weight,
        height = this.height,
        image = this.image
    )
}

fun List<PokemonDataModel>.mapToDomain() : List<PokemonDomainModel> {
    val res = mutableListOf<PokemonDomainModel>()
    this.forEach {
        res.add(it.mapToDomain())
    }
    return res
}