package com.example.finalspace.data.remote

import com.example.finalspace.data.model.character.Characters
import com.example.finalspace.repository.ApiService

class CharacterDataSource(private val apiService: ApiService) {
    suspend fun getAllCharacter(): Characters {
        return apiService.getAllCharacters()
    }
}