package app.seals.pokemonlist.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import app.seals.pokemonlist.R
import app.seals.pokemonlist.domain.interfaces.PokemonRepository
import app.seals.pokemonlist.ui.adapters.RecyclerAdapter
import app.seals.pokemonlist.ui.show_pokemon.ShowFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm : MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val swipe =  findViewById<SwipeRefreshLayout>(R.id.swipeRefresh)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val recyclerAdapter = RecyclerAdapter(vm.list, supportFragmentManager)
        recycler.adapter = recyclerAdapter
        recycler.layoutManager = LinearLayoutManager(applicationContext)
        vm.loadListFromLocalStorage()
        swipe.setOnRefreshListener {
            vm.load()
            swipe.isRefreshing = false
        }

        vm.list.observe(this) {
            recycler.adapter?.notifyDataSetChanged()
        }
    }

}