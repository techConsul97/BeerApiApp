package com.sebqv97.scratchmvvmroomimplementation.data.roomdb
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sebqv97.scratchmvvmroomimplementation.data.model.Beers

class BeerTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun beersToString(beers: Beers): String = gson.toJson(beers)

    @TypeConverter
    fun stringToBeers(data: String): Beers {
        val listType = object : TypeToken<Beers>() {}.type
        return gson.fromJson(data, listType)
    }
}