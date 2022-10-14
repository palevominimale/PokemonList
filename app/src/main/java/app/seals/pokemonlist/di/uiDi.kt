package app.seals.pokemonlist.di

import app.seals.pokemonlist.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiDi = module {

    viewModel {
        MainActivityViewModel(
            api = get(),
            repo = get()
        )
    }

}