package app.seals.pokemonlist.di

import app.seals.pokemonlist.ui.main.MainActivityViewModel
import app.seals.pokemonlist.ui.show_pokemon.ShowFragment
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.math.sin

val uiDi = module {

    viewModel {
        MainActivityViewModel(
            api = get(),
            repo = get()
        )
    }

    single {
        ShowFragment(
            pokemonRepository = get(),
            api = get(),
            checkInternet = get()
        )
    }
}