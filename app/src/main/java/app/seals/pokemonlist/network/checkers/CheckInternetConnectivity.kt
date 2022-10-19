package app.seals.pokemonlist.network.checkers

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import org.koin.core.component.getScopeName

open class CheckInternetConnectivity (context: Context) {
    companion object {
        val TAG = getScopeName()
    }

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

    open fun invoke() : Boolean {
        val isConnected = connectivityManager?.getNetworkCapabilities(connectivityManager.activeNetwork) != null
//        Log.e("${TAG}_CIC", "Connection is established: $isConnected")
        return isConnected
    }

}