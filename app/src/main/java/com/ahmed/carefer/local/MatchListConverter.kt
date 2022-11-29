package com.ahmed.carefer.local

import androidx.room.TypeConverter
import com.ahmed.carefer.models.Matche
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MatchListConverter {

    @TypeConverter
    fun fromStringArrayList(value: List<Matche>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toStringArrayList(value: String): List<Matche> {
        return try {
            Gson().fromJson(value, object : TypeToken<List<Matche?>?>() {}.getType())
        } catch (e: Exception) {
            arrayListOf()
        }
    }
}
