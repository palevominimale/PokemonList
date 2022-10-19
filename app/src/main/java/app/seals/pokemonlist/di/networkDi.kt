package app.seals.pokemonlist.di

import app.seals.pokemonlist.domain.interfaces.ApiGetData
import app.seals.pokemonlist.network.api.ApiGetDataImpl
import app.seals.pokemonlist.network.api.ApiRequest
import app.seals.pokemonlist.network.checkers.CheckInternetConnectivity
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkDi = module {

    factory {
        CheckInternetConnectivity(
            context = androidContext()
        )
    }

    factory <ApiGetData>{
        ApiGetDataImpl(
            apiRequest = get(),
            checkInternet = get()
        )
    }

    factory {
        ApiRequest()
    }
}