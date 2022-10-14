package app.seals.pokemonlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import app.seals.pokemonlist.R
import app.seals.pokemonlist.domain.models.PokemonDomainModel
import app.seals.pokemonlist.domain.models.PokemonListDomainModel
import app.seals.pokemonlist.ui.adapters.RecyclerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm : MainActivityViewModel by viewModel()
    private var pokemonList = PokemonListDomainModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val swipe =  findViewById<SwipeRefreshLayout>(R.id.swipeRefresh)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = RecyclerAdapter(vm.list.value ?: PokemonListDomainModel())
        recycler.layoutManager = LinearLayoutManager(applicationContext)

        swipe.setOnRefreshListener {
            vm.load()
            swipe.isRefreshing = false
        }

        vm.list.observe(this) {
            recycler.adapter?.notifyDataSetChanged()
        }
    }

}