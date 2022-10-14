package app.seals.pokemonlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.seals.pokemonlist.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm : MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm.load()
    }

}