package app.seals.pokemonlist.network

import app.seals.pokemonlist.domain.interfaces.ApiGetData
import app.seals.pokemonlist.domain.models.PokemonListDomainModel
import com.google.gson.Gson

class ApiGetDataImpl (private val apiRequest: ApiRequest) : ApiGetData {
    override suspend fun invoke() : PokemonListDomainModel {
        return Gson().fromJson(
            apiRequest.retrofit.getPokemonsList(),
            PokemonListDomainModel::class.java
        )
    }
}