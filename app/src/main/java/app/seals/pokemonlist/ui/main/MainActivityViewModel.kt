package app.seals.pokemonlist.ui.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.seals.pokemonlist.domain.interfaces.ApiGetData
import app.seals.pokemonlist.domain.interfaces.PokemonRepository
import app.seals.pokemonlist.domain.models.PokemonListDomainModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
open class MainActivityViewModel(
    private val api : ApiGetData,
    private val repo : PokemonRepository
) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)
    val list = MutableLiveData(PokemonListDomainModel())
    val connectionError = MutableLiveData(false)
    val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)

    var receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val notConnected = intent.getBooleanExtra(
                ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
            if (notConnected) {
                connectionError.postValue(true)
            } else {
                connectionError.postValue(false)
            }
        }
    }

    open fun load() {
        var res : PokemonListDomainModel? = null
        scope.launch {
            res = api.invoke()
        }.invokeOnCompletion {
            if (res != null) {
                list.postValue(res)
                repo.clearMini()
                repo.addPokemonMiniList(res!!.results)
            } else {
                connectionError.postValue(true)
            }
        }
    }

    fun loadListFromLocalStorage() {
        val a = repo.getAllMini()
        list.postValue(PokemonListDomainModel(results = ArrayList(a)))
    }
}