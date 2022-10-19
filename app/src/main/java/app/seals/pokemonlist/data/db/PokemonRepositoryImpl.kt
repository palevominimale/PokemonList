package app.seals.pokemonlist.data.db

import android.content.Context
import app.seals.pokemonlist.data.mapMiniListToData
import app.seals.pokemonlist.data.mapMiniListToDomain
import app.seals.pokemonlist.data.mapToData
import app.seals.pokemonlist.data.mapToDomain
import app.seals.pokemonlist.domain.interfaces.PokemonRepository
import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.domain.models.PokemonSmallDomainModel

open class PokemonRepositoryImpl (context: Context) : PokemonRepository {

    open var db : PokemonDAO = PokemonDB.getInstance(context)?.dao()!!

    override fun getPokemonById(id: Long) : PokemonDomainModel? {
        return db.getPokemonByIdData(id)?.mapToDomain()
    }

    override fun getPokemonByName(name: String) : PokemonDomainModel? {
        return db.getPokemonByName(name)?.mapToDomain()
    }

    override fun getPokemonMiniByName(name: String): PokemonSmallDomainModel? {
        return db.getPokemonMiniByName(name)?.mapToDomain()
    }

    override fun getAll(): List<PokemonDomainModel> {
        return db.getAll().mapToDomain()
    }

    override fun getAllMini(): List<PokemonSmallDomainModel> {
        return db.getAllMini().mapMiniListToDomain()
    }

    override fun addPokemon(item: PokemonDomainModel) {
       db.addPokemon(item.mapToData())
    }

    override fun addPokemonMini(item: PokemonSmallDomainModel) {
        db.addPokemonMini(item.mapToData())
    }

    override fun addPokemonMiniList(item: List<PokemonSmallDomainModel>) {
        db.addPokemonMiniList(item.mapMiniListToData())
    }

    override fun clear() {
        db.clear()
    }

    override fun clearMini() {
        db.clear()
    }

}