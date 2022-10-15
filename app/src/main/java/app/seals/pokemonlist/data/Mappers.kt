package app.seals.pokemonlist.data

import app.seals.pokemonlist.data.models.PokemonDataModel
import app.seals.pokemonlist.data.models.PokemonSmallDataModel
import app.seals.pokemonlist.data.models.SpritesDataModel
import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.domain.models.PokemonSmallDomainModel
import app.seals.pokemonlist.domain.models.SpritesDomainModel

fun PokemonSmallDomainModel.mapToData() : PokemonSmallDataModel {
    return PokemonSmallDataModel(name ?: "", url)
}

fun PokemonSmallDataModel.mapToDomain() : PokemonSmallDomainModel {
    return PokemonSmallDomainModel(name, url)
}

fun List<PokemonSmallDataModel>.mapMiniListToDomain() : List<PokemonSmallDomainModel> {
    val res = mutableListOf<PokemonSmallDomainModel>()
    this.forEach {
        res.add(it.mapToDomain())
    }
    return res
}

fun List<PokemonSmallDomainModel>.mapMiniListToData() : List<PokemonSmallDataModel> {
    val res = mutableListOf<PokemonSmallDataModel>()
    this.forEach {
        res.add(it.mapToData())
    }
    return res
}

fun PokemonDataModel.mapToDomain() : PokemonDomainModel {
    return PokemonDomainModel(
        id = this.id,
        name = this.name,
        types = this.types,
        weight = this.weight,
        height = this.height,
        sprites = this.sprites?.mapToDomain()
    )
}

fun PokemonDomainModel.mapToData() : PokemonDataModel {
    return PokemonDataModel(
        id = this.id,
        name = this.name,
        types = this.types,
        weight = this.weight,
        height = this.height,
        sprites = this.sprites?.mapToData()
    )
}

fun List<PokemonDataModel>.mapToDomain() : List<PokemonDomainModel> {
    val res = mutableListOf<PokemonDomainModel>()
    this.forEach {
        res.add(it.mapToDomain())
    }
    return res
}

fun SpritesDataModel.mapToDomain() : SpritesDomainModel {
    return SpritesDomainModel(
        backDefault, backFemale, backShiny, backShinyFemale, frontDefault, frontFemale, frontShiny, frontShinyFemale
    )
}

fun SpritesDomainModel.mapToData() : SpritesDataModel {
    return SpritesDataModel(
        backDefault, backFemale, backShiny, backShinyFemale, frontDefault, frontFemale, frontShiny, frontShinyFemale
    )
}