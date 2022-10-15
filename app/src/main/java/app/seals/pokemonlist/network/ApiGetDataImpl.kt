package app.seals.pokemonlist.network

import android.content.Context
import android.util.Log
import android.widget.Toast
import app.seals.pokemonlist.domain.interfaces.ApiGetData
import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.domain.models.PokemonListDomainModel
import app.seals.pokemonlist.domain.models.PokemonTypesDomainModel
import app.seals.pokemonlist.network.models.PokemonNetworkModel
import com.google.gson.Gson
import retrofit2.HttpException

class ApiGetDataImpl (
    private val apiRequest: ApiRequest
) : ApiGetData {

    override suspend fun invoke() : PokemonListDomainModel {
        return Gson().fromJson(
            apiRequest.retrofit.getPokemonsList(),
            PokemonListDomainModel::class.java
        )
    }

    override suspend fun invoke(id: Int) : PokemonDomainModel {
        var res = PokemonDomainModel()
        try {
            res = Gson().fromJson(
                apiRequest.retrofit.getPokemonById(id),
                PokemonNetworkModel::class.java
            ).mapToDomain()
        } catch (e: HttpException) {
            Log.e("AGDI", "An error has been occurred: ${e.response()}")
        }
        return res
    }

}