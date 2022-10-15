package app.seals.pokemonlist.di

import app.seals.pokemonlist.domain.interfaces.ApiGetData
import app.seals.pokemonlist.network.ApiGetDataImpl
import app.seals.pokemonlist.network.ApiRequest
import org.koin.dsl.module

val networkDi = module {
    factory {
        ApiGetDataImpl(
            apiRequest = ApiRequest()
        )
    }

    factory <ApiGetData>{
        ApiGetDataImpl(
            apiRequest = get()
        )
    }

    factory {
        ApiRequest()
    }
}