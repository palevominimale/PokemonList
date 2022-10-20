package app.seals.pokemonlist.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import app.seals.pokemonlist.R
import app.seals.pokemonlist.network.checkers.CheckInternetConnectivity
import app.seals.pokemonlist.ui.adapters.RecyclerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.java.KoinJavaComponent.inject

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
            if(vm.connectionError.value != true)
            vm.load()
            swipe.isRefreshing = false
        }

        registerReceiver(vm.receiver, vm.filter)

        vm.list.observe(this) {
            recycler.adapter?.notifyDataSetChanged()
        }

        vm.connectionError.observe(this) {
            if(it) {
                Toast.makeText(this, "A connection error has been occurred", Toast.LENGTH_SHORT).show()
                supportActionBar?.title = "${getString(R.string.app_name)} - No internet!"
            } else {
                Toast.makeText(this, "Internet connection has been established", Toast.LENGTH_SHORT).show()
                supportActionBar?.title = getString(R.string.app_name)
            }
        }
    }

}