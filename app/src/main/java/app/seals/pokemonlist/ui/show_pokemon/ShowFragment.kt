package app.seals.pokemonlist.ui.show_pokemon

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import app.seals.pokemonlist.R
import app.seals.pokemonlist.domain.interfaces.ApiGetData
import app.seals.pokemonlist.domain.interfaces.PokemonRepository
import app.seals.pokemonlist.domain.models.PokemonTypesDomainModel
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Suppress("BlockingMethodInNonBlockingContext")
class ShowFragment(
    private val pokemonRepository: PokemonRepository,
    private val api : ApiGetData,
) : DialogFragment() {

    private var id: String? = null
    private val scope = CoroutineScope(Dispatchers.IO)

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
            val pokemonMini = pokemonRepository.getPokemonMiniByName(tag ?: "bulbasaur")
            var pokemon = pokemonRepository.getPokemonByName(pokemonMini.name?: "bulbasaur")

            fun load() {
                val sprite = pokemon?.sprites?.frontDefault
                var bitmap : Bitmap
                if(!sprite.isNullOrEmpty()) {
                    scope.launch {
                        bitmap = Picasso.get().load(sprite).get()
                        requireActivity().runOnUiThread {
                            icon.setImageBitmap(bitmap)
                        }
                    }
                }
                name.text = pokemon?.name
                val pokemonType = pokemon?.types?.get(0)?.toString() ?: ""
                val typeObj = Gson().fromJson(pokemonType, PokemonTypesDomainModel::class.java)
                type.text = typeObj.type?.name
                height.text = "${pokemon?.height} cm"
                weight.text = "${pokemon?.weight} kg"
            }

            if (pokemon != null) {
                load()
            } else {
                scope.launch {
                    pokemonRepository.addPokemon(api.invoke(pokemonMini.url?.toUri()?.lastPathSegment?.toInt() ?: 0))
                }.invokeOnCompletion {
                    pokemon = pokemonRepository.getPokemonByName(pokemonMini.name ?: "bulbasaur")
                    requireActivity().runOnUiThread {
                        load()
                    }
                }
            }
        }
    }

    override fun show(manager: FragmentManager, tag: String?) {
        super.show(manager, tag)
        id = tag
    }

}