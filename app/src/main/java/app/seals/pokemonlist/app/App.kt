package app.seals.pokemonlist.app

import android.app.Application
import app.seals.pokemonlist.di.dataDi
import app.seals.pokemonlist.di.domainDi
import app.seals.pokemonlist.di.networkDi
import app.seals.pokemonlist.di.uiDi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(
                uiDi,
                domainDi,
                dataDi,
                networkDi
            ))
        }
    }
}