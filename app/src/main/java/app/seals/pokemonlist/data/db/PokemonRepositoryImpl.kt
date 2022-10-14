package app.seals.pokemonlist.data.db

import android.content.Context
import app.seals.pokemonlist.data.mapToData
import app.seals.pokemonlist.data.mapToDomain
import app.seals.pokemonlist.domain.interfaces.PokemonRepository
import app.seals.pokemonlist.domain.models.PokemonDomainModel

class PokemonRepositoryImpl (context: Context) : PokemonRepository {

    private val db : PokemonDAO = PokemonDB.getInstance(context)?.dao()!!

    override fun getPokemonById(id: Long) : PokemonDomainModel {
        return db.getPokemonByIdData(id).mapToDomain()
    }

    override fun getAll(): List<PokemonDomainModel> {
        return db.getAll().mapToDomain()
    }

    override fun addPokemon(item: PokemonDomainModel) {
       db.addPokemon(item.mapToData())
    }

    override fun clear() {
        db.clear()
    }

}