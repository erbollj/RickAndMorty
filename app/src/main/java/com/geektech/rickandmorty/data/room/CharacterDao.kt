package com.geektech.rickandmorty.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geektech.rickandmorty.data.model.Character

@Dao
interface CharacterDao {

    @Insert
    suspend fun addCharacter(character: Character)

    @Query("SELECT * FROM character")
    suspend fun getAllCharacters(): List<Character>

}