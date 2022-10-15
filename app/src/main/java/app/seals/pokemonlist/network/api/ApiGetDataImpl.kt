package app.seals.pokemonlist.network.api

import android.util.Log
import app.seals.pokemonlist.domain.interfaces.ApiGetData
import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.domain.models.PokemonListDomainModel
import app.seals.pokemonlist.network.checkers.CheckInternetConnectivity
import app.seals.pokemonlist.network.mapToDomain
import app.seals.pokemonlist.network.models.PokemonNetworkModel
import com.google.gson.Gson
import org.koin.core.component.getScopeName
import retrofit2.HttpException

class ApiGetDataImpl (
    private val apiRequest: ApiRequest,
    private val checkInternet: CheckInternetConnectivity
) : ApiGetData {

    companion object {
        val TAG = getScopeName()
    }

    override suspend fun invoke() : PokemonListDomainModel {
        return if(checkInternet.invoke()){
            Gson().fromJson(
                apiRequest.retrofit.getPokemonsList(),
                PokemonListDomainModel::class.java
            )
        } else PokemonListDomainModel()

    }

    override suspend fun invoke(id: Int) : PokemonDomainModel {
        var res = PokemonDomainModel()
        return if(checkInternet.invoke()) {
            try {
                res = Gson().fromJson(
                    apiRequest.retrofit.getPokemonById(id),
                    PokemonNetworkModel::class.java
                ).mapToDomain()
            } catch (e: HttpException) {
                Log.e("${TAG}_AGDI", "An error has been occurred: ${e.response()}")
            }
            res
        } else res
    }

}