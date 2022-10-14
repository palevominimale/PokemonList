package app.seals.pokemonlist.di

import app.seals.pokemonlist.network.ApiGetDataImpl
import app.seals.pokemonlist.network.ApiRequest
import org.koin.dsl.module

val networkDi = module {
    single {
        ApiGetDataImpl(
            apiRequest = ApiRequest()
        )
    }
}