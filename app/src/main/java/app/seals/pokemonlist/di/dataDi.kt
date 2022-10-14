package app.seals.pokemonlist.di

import app.seals.pokemonlist.data.db.PokemonRepositoryImpl
import app.seals.pokemonlist.domain.interfaces.PokemonRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataDi = module {
    single <PokemonRepository> {
        PokemonRepositoryImpl(
            context = androidContext()
        )
    }
}