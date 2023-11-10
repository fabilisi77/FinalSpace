package com.example.finalspace.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.finalspace.core.Result
import com.example.finalspace.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers

class CharacterViewModel(private val repo: CharacterRepository) : ViewModel() {

    fun fetchAllCharacter() = liveData(Dispatchers.IO) {
        emit(Result.Loading())

        try {
            emit(Result.Success(repo.getAllCharacter()))

        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}

class CharacterViewModelFactory(private val repo: CharacterRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CharacterRepository::class.java).newInstance(repo)
    }

}