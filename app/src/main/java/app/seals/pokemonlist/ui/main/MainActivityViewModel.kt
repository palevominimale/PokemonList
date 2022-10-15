package app.seals.pokemonlist.ui.main

import android.util.Log
import android.util.Patterns
import androidx.core.net.toUri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.seals.pokemonlist.domain.interfaces.ApiGetData
import app.seals.pokemonlist.domain.interfaces.PokemonRepository
import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.domain.models.PokemonListDomainModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class MainActivityViewModel(
    private val api : ApiGetData,
    private val repo : PokemonRepository
) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)
    val list = MutableLiveData(PokemonListDomainModel())

    fun load() {
        var res = PokemonListDomainModel()
        scope.launch {
            res = api.invoke()
        }.invokeOnCompletion {
            list.postValue(res)
            repo.clearMini()
            repo.addPokemonMiniList(res.results)
            Log.e("MAVM", "${res.results}")
            Log.e("MAVM_mini", "${repo.getAllMini()}")
        }
    }

    fun loadListFromLocalStorage() {
        val a = repo.getAllMini()
        list.postValue(PokemonListDomainModel(results = ArrayList(a)))
    }

    fun loadId(id: Int) {
        var res = PokemonDomainModel()
        scope.launch {
            res = api.invoke(id)
        }.invokeOnCompletion {
            Log.e("MAVM", "$res")
        }
    }
}