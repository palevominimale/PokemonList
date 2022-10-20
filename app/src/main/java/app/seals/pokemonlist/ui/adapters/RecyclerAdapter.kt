package app.seals.pokemonlist.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import app.seals.pokemonlist.R
import app.seals.pokemonlist.domain.models.PokemonListDomainModel
import app.seals.pokemonlist.ui.show_pokemon.ShowFragment
import org.koin.java.KoinJavaComponent.inject

class RecyclerAdapter(
    private val data: MutableLiveData<PokemonListDomainModel>,
    private val fragmentManager: FragmentManager
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val showFragment : ShowFragment by inject(ShowFragment::class.java)

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val name: TextView = item.findViewById(R.id.pokemonName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_recycler_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = data.value?.results?.get(position)?.name
        holder.name.text = name
        holder.itemView.setOnClickListener {
            showFragment.show(fragmentManager, holder.name.text?.toString())
        }
    }

    override fun getItemCount(): Int = data.value?.results?.size ?: 0

}