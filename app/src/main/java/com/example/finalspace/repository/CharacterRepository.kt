package com.example.finalspace.repository

import com.example.finalspace.data.model.character.Character

interface CharacterRepository {
    suspend fun getAllCharacter(): List<Character>
    suspend fun searchCharacters(query: String): List<Character>
}