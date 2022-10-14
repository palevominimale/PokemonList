package app.seals.pokemonlist.ui.show_pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import app.seals.pokemonlist.R
import app.seals.pokemonlist.domain.interfaces.PokemonRepository
import com.squareup.picasso.Picasso

class ShowFragment(
    private val pokemonRepository: PokemonRepository
) : DialogFragment() {

    private var id: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = view.findViewById<TextView>(R.id.pokemonNameDialog)
        val type = view.findViewById<TextView>(R.id.pokemonTypeDialog)
        val height = view.findViewById<TextView>(R.id.pokemonHeightDialog)
        val weight = view.findViewById<TextView>(R.id.pokemonWeightDialog)
        val icon = view.findViewById<ImageView>(R.id.pokemonIconDialog)
        val close = view.findViewById<Button>(R.id.closeFragment)

        close.setOnClickListener {
            dismiss()
        }

        if (!tag.isNullOrEmpty()) {
            val pokemon = pokemonRepository.getPokemonById(tag?.toLongOrNull() ?: 0)
            val sprite = pokemon.sprites?.frontDefault
            if(!sprite.isNullOrEmpty()) icon.setImageBitmap(Picasso.get().load(sprite).get())
            name.text = pokemon.name
            type.text = pokemon.types[0].asString
            height.text = pokemon.height.toString()
            weight.text = pokemon.weight.toString()
        }
    }

    override fun show(manager: FragmentManager, tag: String?) {
        super.show(manager, tag)
        id = tag
    }

}