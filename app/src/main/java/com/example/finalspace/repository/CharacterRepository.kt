package com.example.finalspace.repository

import com.example.finalspace.data.model.character.Characters

interface CharacterRepository {
    suspend fun getAllCharacter(): Characters
}