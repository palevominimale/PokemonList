package app.seals.pokemonlist.ui.show_pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import app.seals.pokemonlist.R

class ShowFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        isCancelable = false
        return inflater.inflate(R.layout.fragment_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = view.findViewById<TextView>(R.id.pokemonNameDialog)
        val type = view.findViewById<TextView>(R.id.pokemonTypeDialog)
        val height = view.findViewById<TextView>(R.id.pokemonHeightDialog)
        val weight = view.findViewById<TextView>(R.id.pokemonWeightDialog)
    }

}