package app.seals.pokemonlist.ui.adapters

import android.graphics.Bitmap
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import app.seals.pokemonlist.R
import app.seals.pokemonlist.domain.models.PokemonListDomainModel
import com.squareup.picasso.Picasso

class RecyclerAdapter(
    private val data: MutableLiveData<PokemonListDomainModel>
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val name: TextView = item.findViewById(R.id.pokemonName)
        val icon: ImageView = item.findViewById(R.id.pokemonIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_recycler_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val icon = data.value?.results?.get(position)?.sprites?.frontDefault
        val bitmap : Bitmap
        if (icon != null) {
            bitmap = Picasso.get().load(icon).get()
            holder.icon.setImageBitmap(bitmap)
        }
        holder.name.text = data.value?.results?.get(position)?.name
        Log.e("RA", "$position $icon")
    }

    override fun getItemCount(): Int = data.value?.results?.size ?: 0

}