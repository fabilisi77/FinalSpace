package com.example.finalspace.repository

import com.example.finalspace.data.model.character.Character
import com.example.finalspace.data.remote.CharacterDataSource

class   CharacterRepositoryImpl(private val dataSource: CharacterDataSource): CharacterRepository {
    override suspend fun getAllCharacter(): List<Character> {
        return dataSource.getAllCharacter()
    }

    override suspend fun searchCharacters(query: String): List<Character> {
        return dataSource.searchCharacters(query)
    }
}