package com.geektech.rickandmorty.data.room

import androidx.room.TypeConverter
import com.geektech.rickandmorty.data.model.Info
import com.geektech.rickandmorty.data.model.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

object Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromInfo(data: Info): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun toInfo(data: String): Info {
        return gson.fromJson(data, Info::class.java)
    }

    @TypeConverter
    fun fromListOfResult(data: List<Result?>): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun toListOfResult(data: String?): List<Result?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Result?>?>() {}.type
        return gson.fromJson(data, listType)
    }



}