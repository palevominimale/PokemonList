package app.seals.pokemonlist.network

import com.google.gson.JsonObject
import retrofit2.http.GET

interface ApiInterface {
    @GET("")
    suspend fun getPokemonsList() : JsonObject

    companion object {
        const val BASE_URL = """https://pokeapi.co/api/v2/pokemon/"""
    }
}