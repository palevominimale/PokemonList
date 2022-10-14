package app.seals.pokemonlist.data

import androidx.room.TypeConverter
import app.seals.pokemonlist.data.models.SpritesDataModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun stringToJsonObject(data: String?) : ArrayList<JsonObject> {
        if(data.isNullOrEmpty()) {
            return arrayListOf(JsonObject())
        }
        val type : Type = object: TypeToken<ArrayList<JsonObject>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun jsonObjectToString(data: ArrayList<JsonObject>) : String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun spritesToString(data: SpritesDataModel) : String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToSprites(data: String?) : SpritesDataModel {
        if(data.isNullOrEmpty()) {
            return SpritesDataModel()
        }
        val type : Type = object: TypeToken<SpritesDataModel>() {}.type
        return gson.fromJson(data, type)
    }
}