package app.seals.pokemonlist.domain.interfaces

import android.content.Context
import app.seals.pokemonlist.data.db.PokemonDAO
import app.seals.pokemonlist.data.db.PokemonRepositoryImpl
import app.seals.pokemonlist.data.models.PokemonDataModel
import app.seals.pokemonlist.data.models.PokemonSmallDataModel
import app.seals.pokemonlist.domain.models.PokemonDomainModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class PokemonRepositoryTest {

    private val dao = mock<PokemonDAO>{
        on { getAll() } doReturn listOf(PokemonDataModel())
        on { getAllMini() } doReturn listOf(PokemonSmallDataModel())
        on { getPokemonByName("") } doReturn null
        on { getPokemonMiniByName("") } doReturn null
    }
    private val context = mock<Context>()
    private val repo = PokemonRepositoryImpl(context)

    @BeforeEach
    fun init() {
        repo.db = dao
    }

    @Test
    fun getAll_expectedListOfPokemonDataModel() {
        val res = repo.getAll()
        Assertions.assertEquals(listOf(PokemonDomainModel()), res)
    }

    @Test
    fun getWithEmptyName_expected_null() {
        val res = repo.getPokemonByName("")
        Assertions.assertEquals(null, res)
    }

    @Test
    fun getSmallWithEmptyName_expected_null() {
        val res = repo.getPokemonMiniByName("")
        Assertions.assertEquals(null, res)
    }
}