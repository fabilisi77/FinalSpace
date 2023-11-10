package com.example.finalspace.repository

import com.example.finalspace.data.model.character.Characters
import com.example.finalspace.data.remote.CharacterDataSource

class CharacterRepositoryImpl(private val dataSource: CharacterDataSource): CharacterRepository {
    override suspend fun getAllCharacter(): Characters {
        return dataSource.getAllCharacter()
    }
}