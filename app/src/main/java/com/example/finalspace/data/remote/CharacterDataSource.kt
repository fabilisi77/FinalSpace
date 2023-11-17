package com.example.finalspace.data.remote

import com.example.finalspace.data.model.character.Character
import com.example.finalspace.repository.ApiService

class CharacterDataSource(private val apiService: ApiService) {
    suspend fun getAllCharacter():List<Character> {
        return apiService.getAllCharacters()
    }

    suspend fun searchCharacters(query: String): List<Character>{
        return apiService.searchCharacters(query)
    }
}