package com.example.finalspace.presentation

import android.util.Log
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
            val data = repo.getAllCharacter()
            emit(Result.Success(data))
            Log.d("CharacterFragment", "Data received: $data")


        } catch (e: Exception) {
            Log.e("CharacterFragment", "Error fetching data: ${e.message}", e)
            emit(Result.Failure(e))
        }
    }

    fun fetchCharacterByName()= liveData(Dispatchers.IO){
        emit(Result.Loading())

        try {
            val data = repo.getAllCharacter()
            emit(Result.Success(data))
            Log.d("CharacterFragment", "Data received: $data")


        } catch (e: Exception) {
            Log.e("CharacterFragment", "Error fetching data: ${e.message}", e)
            emit(Result.Failure(e))
        }
    }
}





class CharacterViewModelFactory(private val repo: CharacterRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CharacterRepository::class.java).newInstance(repo)
    }

}