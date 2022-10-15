package app.seals.pokemonlist.network.api

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("pokemon/")
    suspend fun getPokemonsList() : JsonObject

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int) : JsonObject

    companion object {
        const val BASE_URL = """https://pokeapi.co/api/v2/"""
    }
}