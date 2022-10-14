package app.seals.pokemonlist.network

import app.seals.pokemonlist.domain.interfaces.ApiGetData
import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.domain.models.PokemonListDomainModel
import app.seals.pokemonlist.network.models.PokemonNetworkModel
import com.google.gson.Gson

class ApiGetDataImpl (private val apiRequest: ApiRequest) : ApiGetData {

    override suspend fun invoke() : PokemonListDomainModel {
        return Gson().fromJson(
            apiRequest.retrofit.getPokemonsList(),
            PokemonListDomainModel::class.java
        )
    }

    override suspend fun invoke(id: Int) : PokemonDomainModel {
        return Gson().fromJson(
            apiRequest.retrofit.getPokemonById(id),
            PokemonNetworkModel::class.java
        ).mapToDomain()
    }

}