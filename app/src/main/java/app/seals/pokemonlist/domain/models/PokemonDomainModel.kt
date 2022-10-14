package app.seals.pokemonlist.domain.models

import java.io.Serializable

data class PokemonDomainModel(
    val id: Long = 0L,
    val name: String = "",
    val type: String = "",
    val weight: Int = 0,
    val height: Int = 0,
    val image: String = ""
) : Serializable