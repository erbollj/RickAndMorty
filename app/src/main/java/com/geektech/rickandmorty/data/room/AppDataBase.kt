package com.geektech.rickandmorty.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.geektech.rickandmorty.data.model.Character

@Database(entities = [Character::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDataBase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}