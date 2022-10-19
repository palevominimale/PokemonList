package app.seals.pokemonlist.domain.interfaces

import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.domain.models.PokemonListDomainModel
import app.seals.pokemonlist.network.api.ApiGetDataImpl
import app.seals.pokemonlist.network.api.ApiRequest
import app.seals.pokemonlist.network.checkers.CheckInternetConnectivity
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

private const val ACTUAL_LIST = """PokemonListDomainModel(count=1154, next=https://pokeapi.co/api/v2/pokemon/?offset=20&limit=20, previous=null, results=[PokemonSmallDomainModel(name=bulbasaur, url=https://pokeapi.co/api/v2/pokemon/1/), PokemonSmallDomainModel(name=ivysaur, url=https://pokeapi.co/api/v2/pokemon/2/), PokemonSmallDomainModel(name=venusaur, url=https://pokeapi.co/api/v2/pokemon/3/), PokemonSmallDomainModel(name=charmander, url=https://pokeapi.co/api/v2/pokemon/4/), PokemonSmallDomainModel(name=charmeleon, url=https://pokeapi.co/api/v2/pokemon/5/), PokemonSmallDomainModel(name=charizard, url=https://pokeapi.co/api/v2/pokemon/6/), PokemonSmallDomainModel(name=squirtle, url=https://pokeapi.co/api/v2/pokemon/7/), PokemonSmallDomainModel(name=wartortle, url=https://pokeapi.co/api/v2/pokemon/8/), PokemonSmallDomainModel(name=blastoise, url=https://pokeapi.co/api/v2/pokemon/9/), PokemonSmallDomainModel(name=caterpie, url=https://pokeapi.co/api/v2/pokemon/10/), PokemonSmallDomainModel(name=metapod, url=https://pokeapi.co/api/v2/pokemon/11/), PokemonSmallDomainModel(name=butterfree, url=https://pokeapi.co/api/v2/pokemon/12/), PokemonSmallDomainModel(name=weedle, url=https://pokeapi.co/api/v2/pokemon/13/), PokemonSmallDomainModel(name=kakuna, url=https://pokeapi.co/api/v2/pokemon/14/), PokemonSmallDomainModel(name=beedrill, url=https://pokeapi.co/api/v2/pokemon/15/), PokemonSmallDomainModel(name=pidgey, url=https://pokeapi.co/api/v2/pokemon/16/), PokemonSmallDomainModel(name=pidgeotto, url=https://pokeapi.co/api/v2/pokemon/17/), PokemonSmallDomainModel(name=pidgeot, url=https://pokeapi.co/api/v2/pokemon/18/), PokemonSmallDomainModel(name=rattata, url=https://pokeapi.co/api/v2/pokemon/19/), PokemonSmallDomainModel(name=raticate, url=https://pokeapi.co/api/v2/pokemon/20/)])"""
private const val POKEMON_1 = """PokemonDomainModel(height=7, id=1, name=bulbasaur, types=[{"slot":1,"type":{"name":"grass","url":"https://pokeapi.co/api/v2/type/12/"}}, {"slot":2,"type":{"name":"poison","url":"https://pokeapi.co/api/v2/type/4/"}}], weight=69, sprites=SpritesDomainModel(backDefault=https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/1.png, backFemale=null, backShiny=https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/1.png, backShinyFemale=null, frontDefault=https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png, frontFemale=null, frontShiny=https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png, frontShinyFemale=null), url=null)"""

class ApiGetDataTest {

    private val checkInternet : CheckInternetConnectivity = mock()
    private val api = ApiGetDataImpl(ApiRequest(), checkInternet)

    @Test
    fun apiInvokeTest_expectingList() {
        var res: PokemonListDomainModel?
        runBlocking {
            Mockito.`when`(checkInternet.invoke()).doReturn(true)
            res = api.invoke()
            Assertions.assertEquals(ACTUAL_LIST, res.toString())
        }
    }

    @Test
    fun apiInvokeTest_expectingSingle() {
        var res1: PokemonDomainModel?
        runBlocking {
            Mockito.`when`(checkInternet.invoke()).doReturn(true)
            res1 = api.invoke(1)
            Assertions.assertEquals(POKEMON_1, res1.toString())
        }
    }

    @Test
    fun apiInvokeNoInternet_expectingNull() {
        var res2: PokemonListDomainModel?
        runBlocking {
            Mockito.`when`(checkInternet.invoke()).doReturn(false)
            res2 = api.invoke()
            Assertions.assertEquals(null, res2)
        }
    }
}